package org.dutyfarm.core.dao.impl;

import de.hybris.platform.servicelayer.internal.dao.DefaultGenericDao;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.SearchResult;
import org.apache.log4j.Logger;
import org.dutyfarm.core.dao.FlowerDao;
import org.dutyfarm.core.model.FlowerProductModel;
import org.dutyfarm.core.model.FlowerVariantProductModel;

import java.util.List;

public class DefaultFlowerDao extends DefaultGenericDao<FlowerProductModel> implements FlowerDao {

    private static final Logger LOG = Logger.getLogger(DefaultFlowerDao.class);

    public DefaultFlowerDao(String typecode) {
        super(typecode);
    }

    @Override
    public List<FlowerProductModel> findAllFlowers() {
        LOG.info("Invoke method findAllFlowers in DefaultFlowerDao");
        final StringBuilder queryStr = new StringBuilder();
        queryStr.append("SELECT {p.pk} from {FlowerProduct as p}");
        final FlexibleSearchQuery fsq = new FlexibleSearchQuery(queryStr);
        final SearchResult<FlowerProductModel> result = this.getFlexibleSearchService().search(fsq);
        return result.getResult();
    }

}
