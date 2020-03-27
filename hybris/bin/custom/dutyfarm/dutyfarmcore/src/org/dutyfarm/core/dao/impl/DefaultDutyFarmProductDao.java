package org.dutyfarm.core.dao.impl;

import de.hybris.platform.category.constants.CategoryConstants;
import de.hybris.platform.category.model.CategoryModel;
import de.hybris.platform.core.model.link.LinkModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.internal.dao.DefaultGenericDao;
import de.hybris.platform.servicelayer.internal.dao.SortParameters;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.SearchResult;
import de.hybris.platform.util.FlexibleSearchUtils;
import org.apache.log4j.Logger;
import org.dutyfarm.core.dao.DutyFarmProductDao;
import org.dutyfarm.core.model.FertilizerProductModel;

import java.util.*;

public class DefaultDutyFarmProductDao  extends DefaultGenericDao<ProductModel> implements DutyFarmProductDao {

    private static final Logger LOG = Logger.getLogger(DefaultDutyFarmProductDao.class);

    private static final String FIND_ALL_PRODUCTS = "SELECT {p.pk} FROM {Product AS p JOIN CategoryProductRelation AS cpr ON {p.pk} = {cpr.target} JOIN Category AS c ON {c.pk} = {cpr.source} }";
    private static final String COUNT_ALL_PRODUCTS = "SELECT COUNT({p.pk}) FROM {Product AS p JOIN CategoryProductRelation AS cpr ON {p.pk} = {cpr.target} JOIN Category AS c ON {c.pk} = {cpr.source} }";
    //private static final String FIND_ALL_PRODUCTS_BY_CATEGORY = "SELECT {p.pk} FROM { Product AS p JOIN CategoryProductRelation AS cpr ON {p.pk} = {cpr.target} JOIN Category AS c ON {c.pk} = {cpr.source} } WHERE {c.code} LIKE ?category";
    private static final String FIND_ALL_RPDOUCTS_BY_NAME = "SELECT {p.pk} FROM { Product AS p JOIN CategoryProductRelation AS cpr ON {p.pk} = {cpr.target} JOIN Category AS c ON {c.pk} = {cpr.source} } WHERE {p.name} LIKE %?name%";

    public DefaultDutyFarmProductDao(String typecode) {
        super(typecode);
    }

    @Override
    public List<ProductModel> findAllProducts(int start, int count) {
        LOG.info("Invoke method findAllProducts in DefaultDutyFarmProductDao");
        final FlexibleSearchQuery fsq = new FlexibleSearchQuery(FIND_ALL_PRODUCTS);
        fsq.setCount(count);
        fsq.setStart(start);
        final SearchResult<ProductModel> result = getFlexibleSearchService().search(fsq);
        LOG.info("Number of elements in result (ProductModel): " +result.getResult().size());
        return result.getResult();
    }

    @Override
    public Integer countAllProducts() {
        LOG.info("Invoke method countAllProducts in DefaultDutyFarmProductDao");
        final Map params = new HashMap();
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT COUNT({p:").append(ProductModel.PK).append("}) ");
        stringBuilder.append("FROM {").append(ProductModel._TYPECODE).append(" AS p ");
        stringBuilder.append("JOIN ").append(CategoryConstants.Relations.CATEGORYPRODUCTRELATION).append(" AS l ");
        stringBuilder.append("ON {l:").append(LinkModel.TARGET).append("}={p:").append(ProductModel.PK).append("} } ");

        final FlexibleSearchQuery fsq = new FlexibleSearchQuery(stringBuilder.toString(), params);
        return getFlexibleSearchService().searchUnique(fsq);
    }

    @Override
    public List<ProductModel> findAllProductsForCategory(final CategoryModel category, int start, int count) {
        LOG.info("Invoke method findAllProductsForCategory in DefaultDutyFarmProductDao");
        final Map params = new HashMap();
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT {p:").append(ProductModel.PK).append("} ");
        stringBuilder.append("FROM {").append(ProductModel._TYPECODE).append(" AS p ");
        stringBuilder.append("JOIN ").append(CategoryConstants.Relations.CATEGORYPRODUCTRELATION).append(" AS l ");
        stringBuilder.append("ON {l:").append(LinkModel.TARGET).append("}={p:").append(ProductModel.PK).append("} } ");

        final Collection<CategoryModel> allSubCategories = category.getAllSubcategories();

        final Collection<CategoryModel> cats = new ArrayList<CategoryModel>();
        cats.add(category);
        cats.addAll(allSubCategories);

        final String inPart = FlexibleSearchUtils.buildOracleCompatibleCollectionStatement(//
                "{l:" + LinkModel.SOURCE + "} IN (?cat)", //
                "cat", "AND", cats, params//
        );//

        stringBuilder.append("WHERE ").append(inPart);
        stringBuilder.append(" ORDER BY {p:name}");

        final FlexibleSearchQuery fsq = new FlexibleSearchQuery(stringBuilder.toString());
        fsq.setCount(count);
        fsq.setStart(start);
        fsq.setNeedTotal(true);
        fsq.addQueryParameters(params);
        final SearchResult<ProductModel> result = getFlexibleSearchService().search(fsq);
        LOG.info("Number of elements in result (ProductModel): " +result.getResult().size());
        return result.getResult();
    }

    @Override
    public Integer countAllProductsForCategory(final CategoryModel category) {
        LOG.info("Invoke method countAllProductsForCategory in DefaultDutyFarmProductDao");
        final Map params = new HashMap();
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT COUNT({p:").append(ProductModel.PK).append("}) ");
        stringBuilder.append("FROM {").append(ProductModel._TYPECODE).append(" AS p ");
        stringBuilder.append("JOIN ").append(CategoryConstants.Relations.CATEGORYPRODUCTRELATION).append(" AS l ");
        stringBuilder.append("ON {l:").append(LinkModel.TARGET).append("}={p:").append(ProductModel.PK).append("} } ");

        final Collection<CategoryModel> allSubCategories = category.getAllSubcategories();

        final Collection<CategoryModel> cats = new ArrayList<CategoryModel>();
        cats.add(category);
        cats.addAll(allSubCategories);

        final String inPart = FlexibleSearchUtils.buildOracleCompatibleCollectionStatement(//
                "{l:" + LinkModel.SOURCE + "} IN (?cat)", //
                "cat", "AND", cats, params//
        );//

        stringBuilder.append("WHERE ").append(inPart);
        stringBuilder.append(" ORDER BY {p:name}");

        final FlexibleSearchQuery fsq = new FlexibleSearchQuery(stringBuilder.toString());
        return getFlexibleSearchService().searchUnique(fsq);
    }

    @Override
    public List<ProductModel> findAllProductsForName(String name, int start, int count) {
        LOG.info("Invoke method findAllProductsForName in DefaultDutyFarmProductDao");
        final Map<String, Object> params = new HashMap<String, Object>();
        params.put("name", name);
        final FlexibleSearchQuery fsq = new FlexibleSearchQuery(FIND_ALL_RPDOUCTS_BY_NAME, params);
        fsq.setCount(count);
        fsq.setStart(start);
        final SearchResult<ProductModel> result = getFlexibleSearchService().search(fsq);
        LOG.info("Number of elements in result (ProductModel): " +result.getResult().size());
        return result.getResult();
    }

    @Override
    public Integer countAllProductsForName(String name) {
        LOG.info("Invoke method countAllProductsForName in DefaultDutyFarmProductDao");
        final Map params = new HashMap();
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT COUNT({p:").append(ProductModel.PK).append("}) ");
        stringBuilder.append("FROM {").append(ProductModel._TYPECODE).append(" AS p ");
        stringBuilder.append("JOIN ").append(CategoryConstants.Relations.CATEGORYPRODUCTRELATION).append(" AS l ");
        stringBuilder.append("ON {l:").append(LinkModel.TARGET).append("}={p:").append(ProductModel.PK).append("} } ");
        stringBuilder.append("WHERE {p:").append(ProductModel.NAME).append(" LIKE %?name%");

        params.put("name", name);

        final FlexibleSearchQuery fsq = new FlexibleSearchQuery(stringBuilder.toString(), params);
        return getFlexibleSearchService().searchUnique(fsq);
    }


}
