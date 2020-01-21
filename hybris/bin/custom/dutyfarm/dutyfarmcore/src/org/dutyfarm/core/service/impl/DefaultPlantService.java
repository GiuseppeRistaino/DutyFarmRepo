package org.dutyfarm.core.service.impl;

import org.apache.log4j.Logger;
import org.dutyfarm.core.dao.PlantDao;
import org.dutyfarm.core.model.PlantProductModel;
import org.dutyfarm.core.service.PlantService;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;

public class DefaultPlantService implements PlantService {

    private static final Logger LOG = Logger.getLogger(DefaultPlantService.class);
    private PlantDao plantDao;

    @Override
    public List<PlantProductModel> getAllPlants() {
        LOG.info("Invoke method getAllPlants in DefaultPlantService");
        return plantDao.findAllPlants();
    }

    @Required
    public void setPlantDao(PlantDao plantDao) {
        this.plantDao = plantDao;
    }
}
