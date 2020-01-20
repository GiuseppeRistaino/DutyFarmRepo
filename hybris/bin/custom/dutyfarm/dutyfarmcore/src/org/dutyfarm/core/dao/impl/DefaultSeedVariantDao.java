package org.dutyfarm.core.dao.impl;

import de.hybris.platform.servicelayer.internal.dao.DefaultGenericDao;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.SearchResult;
import org.apache.log4j.Logger;
import org.dutyfarm.core.dao.SeedVariantDao;
import org.dutyfarm.core.model.SeedVariantProductModel;

import java.util.List;

public class DefaultSeedVariantDao extends DefaultGenericDao<SeedVariantProductModel> implements SeedVariantDao {

    private static final Logger LOG = Logger.getLogger(DefaultSeedVariantDao.class);

    public DefaultSeedVariantDao(String typecode) {
        super(typecode);
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
