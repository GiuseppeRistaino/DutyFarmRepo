package org.dutyfarm.core.dao.impl;

import de.hybris.platform.servicelayer.internal.dao.DefaultGenericDao;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.SearchResult;
import org.apache.log4j.Logger;
import org.dutyfarm.core.dao.VegetableDao;
import org.dutyfarm.core.model.VegetableProductModel;
import org.dutyfarm.core.model.VegetableVariantProductModel;

import java.util.List;

public class DefaultVegetableDao extends DefaultGenericDao implements VegetableDao {

    private static final Logger LOG = Logger.getLogger(DefaultVegetableDao.class);

    public DefaultVegetableDao(String typecode) {
        super(typecode);
    }

    @Override
    public List<VegetableProductModel> findAllVegetables() {
        LOG.info("Invoke method findAllVegetables in DefaultVegetableDao");
        final StringBuilder queryStr = new StringBuilder();
        queryStr.append("SELECT {p.pk} from {VegetableProduct as p}");
        final FlexibleSearchQuery fsq = new FlexibleSearchQuery(queryStr);
        final SearchResult<VegetableProductModel> result = this.getFlexibleSearchService().search(fsq);
        return result.getResult();
    }

    @Override
    public List<VegetableVariantProductModel> findVegetablesByFarmingDifficulty(int farmingDifficulty) {
        LOG.info("Invoke method findVegetablesByFarmingDifficulty in DefaultVegetableDao");
        final StringBuilder queryStr = new StringBuilder();
        queryStr.append("SELECT {p.pk} FROM {VegetableVariantProduct as p} WHERE {p.farmingDifficulty} = ?farmingDifficulty");

        final FlexibleSearchQuery fsq = new FlexibleSearchQuery(queryStr);
        fsq.addQueryParameter("farmingDifficulty", farmingDifficulty);
        final SearchResult<VegetableVariantProductModel> result = this.getFlexibleSearchService().search(fsq);
        return result.getResult();
    }
}
