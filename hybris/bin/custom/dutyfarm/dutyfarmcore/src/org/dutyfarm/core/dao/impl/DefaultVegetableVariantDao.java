package org.dutyfarm.core.dao.impl;

import de.hybris.platform.servicelayer.internal.dao.DefaultGenericDao;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.SearchResult;
import org.apache.log4j.Logger;
import org.dutyfarm.core.dao.VegetableDao;
import org.dutyfarm.core.dao.VegetableVariantDao;
import org.dutyfarm.core.model.VegetableVariantProductModel;

import java.util.List;

public class DefaultVegetableVariantDao extends DefaultGenericDao<VegetableVariantProductModel> implements VegetableVariantDao {

    private static final Logger LOG = Logger.getLogger(DefaultVegetableVariantDao.class);

    public DefaultVegetableVariantDao(String typecode) {
        super(typecode);
    }

    @Override
    public List<VegetableVariantProductModel> findVegetablesByFarmingDifficulty(int farmingDifficulty) {
        LOG.info("Invoke method findVegetablesByFarmingDifficulty in DefaultVegetableVariantDao");
        final StringBuilder queryStr = new StringBuilder();
        queryStr.append("SELECT {p.pk} FROM {VegetableVariantProduct as p} WHERE {p.farmingDifficulty} = ?farmingDifficulty");

        final FlexibleSearchQuery fsq = new FlexibleSearchQuery(queryStr);
        fsq.addQueryParameter("farmingDifficulty", farmingDifficulty);
        final SearchResult<VegetableVariantProductModel> result = this.getFlexibleSearchService().search(fsq);
        return result.getResult();
    }
}
