package org.dutyfarm.core.dao.impl;

import de.hybris.platform.servicelayer.internal.dao.DefaultGenericDao;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.SearchResult;
import org.apache.log4j.Logger;
import org.dutyfarm.core.dao.FertilizerDao;
import org.dutyfarm.core.model.FertilizerProductModel;

import java.util.List;

public class DefaultFertilizerDao extends DefaultGenericDao<FertilizerProductModel> implements FertilizerDao {

    private static final Logger LOG = Logger.getLogger(DefaultFertilizerDao.class);

    public DefaultFertilizerDao(String typecode) {
        super(typecode);
    }

    @Override
    public List<FertilizerProductModel> findAllFertilizers() {
        LOG.info("Invoke method findAllFertilizers in DefaultFertilizerDao");
        final StringBuilder queryStr = new StringBuilder();
        queryStr.append("SELECT {f.pk} FROM {FertilizerProduct AS f}");
        final FlexibleSearchQuery fsq = new FlexibleSearchQuery(queryStr);
        final SearchResult<FertilizerProductModel> result = this.getFlexibleSearchService().search(fsq);
        return result.getResult();
    }


}
