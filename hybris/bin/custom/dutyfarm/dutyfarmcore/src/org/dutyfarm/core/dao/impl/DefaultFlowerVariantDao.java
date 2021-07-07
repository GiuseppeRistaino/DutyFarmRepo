package org.dutyfarm.core.dao.impl;

import de.hybris.platform.servicelayer.internal.dao.DefaultGenericDao;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.SearchResult;
import org.apache.log4j.Logger;
import org.dutyfarm.core.dao.FlowerVariantDao;
import org.dutyfarm.core.model.FlowerVariantProductModel;

import java.util.List;

public class DefaultFlowerVariantDao extends DefaultGenericDao<FlowerVariantProductModel> implements FlowerVariantDao {

    private static final Logger LOG = Logger.getLogger(DefaultFlowerVariantDao.class);

    public DefaultFlowerVariantDao(String typecode) {
        super(typecode);
    }

    @Override
    public List<FlowerVariantProductModel> findFlowersByColor(String color) {
        LOG.info("Invoke method findFlowersByColor in DefaultFlowerVariantDao");
        final StringBuilder queryStr = new StringBuilder();
        queryStr.append("SELECT {p.pk} FROM {FlowerVariantProduct as p JOIN SwatchColorEnum as s on {s.pk} = {p.color}} WHERE {s.code} = ?color");

        final FlexibleSearchQuery fsq = new FlexibleSearchQuery(queryStr);
        fsq.addQueryParameter("color", color);
        final SearchResult<FlowerVariantProductModel> result = this.getFlexibleSearchService().search(fsq);
        return result.getResult();
    }

}
