package org.dutyfarm.core.dao.impl;

import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.internal.dao.DefaultGenericDao;
import de.hybris.platform.servicelayer.internal.dao.SortParameters;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.SearchResult;
import org.apache.log4j.Logger;
import org.dutyfarm.core.dao.DutyFarmProductDao;
import org.dutyfarm.core.model.FertilizerProductModel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DefaultDutyFarmProductDao  extends DefaultGenericDao<ProductModel> implements DutyFarmProductDao {

    private static final Logger LOG = Logger.getLogger(DefaultDutyFarmProductDao.class);

    private static final String FIND_ALL_PRODUCTS = "SELECT {p.pk}\n" +
            "FROM {\n" +
            "\tProduct AS p\n" +
            "\tJOIN CategoryProductRelation AS cpr\n" +
            "    ON {p.pk} = {cpr.target}\n" +
            "    JOIN Category AS c\n" +
            "    ON {c.pk} = {cpr.source}\n" +
            "}";
    private static final String FIND_ALL_PRODUCTS_BY_CATEGORY = "SELECT {p.pk}\n" +
            "FROM {\n" +
            "\tProduct AS p\n" +
            "\tJOIN CategoryProductRelation AS cpr\n" +
            "    ON {p.pk} = {cpr.target}\n" +
            "    JOIN Category AS c\n" +
            "    ON {c.pk} = {cpr.source}\n" +
            "}\n" +
            "WHERE {c.code} LIKE ?category";
    private static final String FIND_ALL_RPDOUCTS_BY_NAME = "SELECT {p.pk}\n" +
            "FROM {\n" +
            "\tProduct AS p\n" +
            "\tJOIN CategoryProductRelation AS cpr\n" +
            "    ON {p.pk} = {cpr.target}\n" +
            "    JOIN Category AS c\n" +
            "    ON {c.pk} = {cpr.source}\n" +
            "}\n" +
            "WHERE {p.name} LIKE %?name%";

    public DefaultDutyFarmProductDao(String typecode) {
        super(typecode);
    }

    @Override
    public List<ProductModel> findAllProducts() {
        LOG.info("Invoke method findAllProducts in DefaultDutyFarmProductDao");
        final FlexibleSearchQuery fsq = new FlexibleSearchQuery(FIND_ALL_PRODUCTS);
        final SearchResult<ProductModel> result = getFlexibleSearchService().search(fsq);
        LOG.info("Number of elements in result (ProductModel): " +result.getResult().size());
        return result.getResult();
    }

    @Override
    public List<ProductModel> findAllProductsForCategory(String category) {
        LOG.info("Invoke method findAllProductsForCategory in DefaultDutyFarmProductDao");
        final Map<String, Object> params = new HashMap<String, Object>();
        params.put("category", category);
        final FlexibleSearchQuery fsq = new FlexibleSearchQuery(FIND_ALL_PRODUCTS_BY_CATEGORY, params);
        final SearchResult<ProductModel> result = getFlexibleSearchService().search(fsq);
        LOG.info("Number of elements in result (ProductModel): " +result.getResult().size());
        return result.getResult();
    }

    @Override
    public List<ProductModel> findAllProductsForName(String name) {
        LOG.info("Invoke method findAllProductsForName in DefaultDutyFarmProductDao");
        final Map<String, Object> params = new HashMap<String, Object>();
        params.put("name", name);
        final FlexibleSearchQuery fsq = new FlexibleSearchQuery(FIND_ALL_RPDOUCTS_BY_NAME, params);
        final SearchResult<ProductModel> result = getFlexibleSearchService().search(fsq);
        LOG.info("Number of elements in result (ProductModel): " +result.getResult().size());
        return result.getResult();
    }


}
