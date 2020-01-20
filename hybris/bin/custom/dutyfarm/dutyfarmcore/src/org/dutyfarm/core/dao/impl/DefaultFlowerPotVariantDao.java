package org.dutyfarm.core.dao.impl;

import de.hybris.platform.servicelayer.internal.dao.DefaultGenericDao;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.SearchResult;
import org.apache.log4j.Logger;
import org.dutyfarm.core.dao.FlowerPotVariantDao;
import org.dutyfarm.core.model.FlowerPotVariantProductModel;

import java.util.List;

public class DefaultFlowerPotVariantDao extends DefaultGenericDao<FlowerPotVariantProductModel> implements FlowerPotVariantDao {

    private static final Logger LOG = Logger.getLogger(DefaultFlowerPotVariantDao.class);

    public DefaultFlowerPotVariantDao(String typecode) {
        super(typecode);
    }

    @Override
    public List<FlowerPotVariantProductModel> findFlowerPotByMaterial(String material) {
        LOG.info("Invoke method findFlowerPotByMaterial in DefaultFlowerPotVariantDao");
        final StringBuilder queryStr = new StringBuilder();
        queryStr.append("SELECT {f.pk} FROM {FlowerPotProduct AS f}");
        queryStr.append("WHERE {f.material} = ?material");
        final FlexibleSearchQuery fsq = new FlexibleSearchQuery(queryStr);
        fsq.addQueryParameter("material", material);
        final SearchResult<FlowerPotVariantProductModel> result = this.getFlexibleSearchService().search(fsq);
        return result.getResult();
    }

}
