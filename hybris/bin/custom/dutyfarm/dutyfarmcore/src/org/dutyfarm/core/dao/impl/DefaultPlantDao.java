package org.dutyfarm.core.dao.impl;

import de.hybris.platform.servicelayer.internal.dao.DefaultGenericDao;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.SearchResult;
import org.apache.log4j.Logger;
import org.dutyfarm.core.dao.PlantDao;
import org.dutyfarm.core.model.PlantProductModel;

import java.util.List;

public class DefaultPlantDao extends DefaultGenericDao implements PlantDao {

    private static final Logger LOG = Logger.getLogger(DefaultPlantDao.class);

    public DefaultPlantDao(String typecode) {
        super(typecode);
    }

    @Override
    public List<PlantProductModel> findAllPlants() {
        LOG.info("Invoke method findAllPlants in DefaultPlantDao");
        final StringBuilder queryStr = new StringBuilder();
        queryStr.append("SELECT {p.pk} from {PlantProduct as p}");
        final FlexibleSearchQuery fsq = new FlexibleSearchQuery(queryStr);
        final SearchResult<PlantProductModel> result = this.getFlexibleSearchService().search(fsq);
        return result.getResult();
    }

    @Override
    public List<PlantProductModel> findPlantsByFarmland(String farmland) {
        LOG.info("Invoke method findPlantsByFarmland in DefaultPlantDao");
        final StringBuilder queryStr = new StringBuilder();
        queryStr.append("SELECT {p.pk} FROM {PlantProduct as p} WHERE {p.farmland} = ?farmland");

        final FlexibleSearchQuery fsq = new FlexibleSearchQuery(queryStr);
        fsq.addQueryParameter("farmland", farmland);
        final SearchResult<PlantProductModel> result = this.getFlexibleSearchService().search(fsq);
        return result.getResult();
    }

}
