package org.dutyfarm.core.dao.impl;

import de.hybris.platform.servicelayer.internal.dao.DefaultGenericDao;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.SearchResult;
import org.apache.log4j.Logger;
import org.dutyfarm.core.dao.FlowerPotDao;
import org.dutyfarm.core.jalo.FlowerPotProduct;
import org.dutyfarm.core.model.FertilizerProductModel;
import org.dutyfarm.core.model.SeedVariantProductModel;

import java.util.List;

public class DefaultFlowerPotDao extends DefaultGenericDao implements FlowerPotDao {

    private static final Logger LOG = Logger.getLogger(DefaultFlowerPotDao.class);

    public DefaultFlowerPotDao(String typecode) {
        super(typecode);
    }

    @Override
    public List<FlowerPotProduct> findAllFlowerPots() {
        LOG.info("Invoke method findAllFlowerPots in DefaultFlowerPotDao");
        final StringBuilder queryStr = new StringBuilder();
        queryStr.append("SELECT {f.pk} FROM {FlowerPotProduct AS f}");
        final FlexibleSearchQuery fsq = new FlexibleSearchQuery(queryStr);
        final SearchResult<FlowerPotProduct> result = this.getFlexibleSearchService().search(fsq);
        return result.getResult();
    }

    @Override
    public List<FlowerPotProduct> findFlowerPotByMaterial(String material) {
        LOG.info("Invoke method findFlowerPotByMaterial in DefaultFlowerPotDao");
        final StringBuilder queryStr = new StringBuilder();
        queryStr.append("SELECT {f.pk} FROM {FlowerPotProduct AS f}");
        queryStr.append("WHERE {f.material} = ?material");
        final FlexibleSearchQuery fsq = new FlexibleSearchQuery(queryStr);
        fsq.addQueryParameter("material", material);
        final SearchResult<FlowerPotProduct> result = this.getFlexibleSearchService().search(fsq);
        return result.getResult();
    }
}
