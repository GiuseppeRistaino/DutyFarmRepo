package org.dutyfarm.core.dao.impl;

import de.hybris.platform.servicelayer.internal.dao.DefaultGenericDao;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.SearchResult;
import org.apache.log4j.Logger;
import org.dutyfarm.core.dao.TreeVariantDao;
import org.dutyfarm.core.model.TreeVariantProductModel;

import java.util.List;

public class DefaultTreeVariantDao extends DefaultGenericDao<TreeVariantProductModel> implements TreeVariantDao {

    private static final Logger LOG = Logger.getLogger(DefaultTreeVariantDao.class);

    public DefaultTreeVariantDao(String typecode) {
        super(typecode);
    }

    @Override
    public List<TreeVariantProductModel> findTreesByOrigin(String origin) {
        LOG.info("Invoke method findTreesByOrigin in DefaultTreeVariantDao");
        final StringBuilder queryStr = new StringBuilder();
        queryStr.append("SELECT {p.pk} FROM {TreeVariantProduct as p} WHERE {p.origin} = ?origin");

        final FlexibleSearchQuery fsq = new FlexibleSearchQuery(queryStr);
        fsq.addQueryParameter("origin", origin);
        final SearchResult<TreeVariantProductModel> result = this.getFlexibleSearchService().search(fsq);
        return result.getResult();
    }
}
