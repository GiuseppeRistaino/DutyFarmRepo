package org.dutyfarm.core.dao.impl;

import de.hybris.platform.servicelayer.internal.dao.DefaultGenericDao;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.SearchResult;
import org.apache.log4j.Logger;
import org.dutyfarm.core.dao.SeedDao;
import org.dutyfarm.core.model.FertilizerProductModel;
import org.dutyfarm.core.model.FertilizerVariantProductModel;
import org.dutyfarm.core.model.SeedProductModel;
import org.dutyfarm.core.model.SeedVariantProductModel;

import java.util.List;

public class DefaultSeedDao extends DefaultGenericDao implements SeedDao {

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

    @Override
    public List<SeedVariantProductModel> findSeedsByOrigin(String origin) {
        LOG.info("Invoke method findSeedsByOrigin in DefaultSeedDao");
        final StringBuilder queryStr = new StringBuilder();
        queryStr.append("SELECT {s.pk} FROM { SeedVariantProduct AS s }");
        queryStr.append("WHERE {s.origin} = ?origin");
        final FlexibleSearchQuery fsq = new FlexibleSearchQuery(queryStr);
        fsq.addQueryParameter("origin", origin);
        final SearchResult<SeedVariantProductModel> result = this.getFlexibleSearchService().search(fsq);
        return result.getResult();
    }
}
