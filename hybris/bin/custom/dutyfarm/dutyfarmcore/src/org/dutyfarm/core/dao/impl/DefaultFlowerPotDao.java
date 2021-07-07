package org.dutyfarm.core.dao.impl;

import de.hybris.platform.servicelayer.internal.dao.DefaultGenericDao;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.SearchResult;
import org.apache.log4j.Logger;
import org.dutyfarm.core.dao.FlowerPotDao;
import org.dutyfarm.core.jalo.FlowerPotProduct;
import org.dutyfarm.core.model.FlowerPotProductModel;


import java.util.List;

public class DefaultFlowerPotDao extends DefaultGenericDao<FlowerPotProductModel> implements FlowerPotDao {

    private static final Logger LOG = Logger.getLogger(DefaultFlowerPotDao.class);

    public DefaultFlowerPotDao(String typecode) {
        super(typecode);
    }

    @Override
    public List<FlowerPotProductModel> findAllFlowerPots() {
        LOG.info("Invoke method findAllFlowerPots in DefaultFlowerPotDao");
        final StringBuilder queryStr = new StringBuilder();
        queryStr.append("SELECT {f.pk} FROM {FlowerPotProduct AS f}");
        final FlexibleSearchQuery fsq = new FlexibleSearchQuery(queryStr);
        final SearchResult<FlowerPotProductModel> result = this.getFlexibleSearchService().search(fsq);
        return result.getResult();
    }

}
