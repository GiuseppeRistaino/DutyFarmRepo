package org.dutyfarm.core.dao.impl;

import de.hybris.platform.servicelayer.internal.dao.DefaultGenericDao;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.SearchResult;
import org.apache.log4j.Logger;
import org.dutyfarm.core.dao.TreeDao;
import org.dutyfarm.core.model.TreeProductModel;
import org.dutyfarm.core.model.TreeVariantProductModel;

import java.util.List;

public class DefaultTreeDao extends DefaultGenericDao implements TreeDao {

    private static final Logger LOG = Logger.getLogger(DefaultTreeDao.class);

    public DefaultTreeDao(String typecode) {
        super(typecode);
    }

    @Override
    public List<TreeProductModel> findAllTrees() {
        LOG.info("Invoke method findAllTrees in DefaultTreeDao");
        final StringBuilder queryStr = new StringBuilder();
        queryStr.append("SELECT {p.pk} from {TreeProduct as p}");
        final FlexibleSearchQuery fsq = new FlexibleSearchQuery(queryStr);
        final SearchResult<TreeProductModel> result = this.getFlexibleSearchService().search(fsq);
        return result.getResult();
    }

    @Override
    public List<TreeVariantProductModel> findTreesByOrigin(String origin) {
        LOG.info("Invoke method findTreesByOrigin in DefaultTreeDao");
        final StringBuilder queryStr = new StringBuilder();
        queryStr.append("SELECT {p.pk} FROM {TreeVariantProduct as p} WHERE {p.origin} = ?origin");

        final FlexibleSearchQuery fsq = new FlexibleSearchQuery(queryStr);
        fsq.addQueryParameter("origin", origin);
        final SearchResult<TreeVariantProductModel> result = this.getFlexibleSearchService().search(fsq);
        return result.getResult();
    }
}
