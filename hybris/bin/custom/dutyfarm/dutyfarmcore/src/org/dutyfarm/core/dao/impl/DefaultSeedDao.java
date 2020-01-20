package org.dutyfarm.core.dao.impl;

import de.hybris.platform.servicelayer.internal.dao.DefaultGenericDao;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.SearchResult;
import org.apache.log4j.Logger;
import org.dutyfarm.core.dao.SeedDao;
import org.dutyfarm.core.model.SeedProductModel;

import java.util.List;

public class DefaultSeedDao extends DefaultGenericDao<SeedProductModel> implements SeedDao {

    private static final Logger LOG = Logger.getLogger(DefaultSeedDao.class);

    public DefaultSeedDao(String typecode) {
        super(typecode);
    }

    @Override
    public List<SeedProductModel> findAllSeeds() {
        LOG.info("Invoke method findAllSeeds in DefaultSeedDao");
        final StringBuilder queryStr = new StringBuilder();
        queryStr.append("SELECT {s.pk} FROM {SeedProduct AS s}");
        final FlexibleSearchQuery fsq = new FlexibleSearchQuery(queryStr);
        final SearchResult<SeedProductModel> result = this.getFlexibleSearchService().search(fsq);
        return result.getResult();
    }


}
