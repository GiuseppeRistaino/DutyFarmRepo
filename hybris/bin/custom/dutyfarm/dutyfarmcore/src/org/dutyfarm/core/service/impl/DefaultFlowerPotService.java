package org.dutyfarm.core.service.impl;

import org.apache.log4j.Logger;
import org.dutyfarm.core.dao.FlowerPotDao;
import org.dutyfarm.core.dao.SeedDao;
import org.dutyfarm.core.model.FlowerPotProductModel;
import org.dutyfarm.core.service.FlowerPotService;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;

public class DefaultFlowerPotService implements FlowerPotService {

    private static final Logger LOG = Logger.getLogger(DefaultFlowerPotService.class);
    private FlowerPotDao flowerPotDao;

    @Override
    public List<FlowerPotProductModel> getAllFlowerPots() {
        LOG.info("Invoke method getAllFlowerPots in DefaultFlowerPotService");
        return flowerPotDao.findAllFlowerPots();
    }

    @Required
    public void setFlowerPotDao(FlowerPotDao flowerPotDao) {
        this.flowerPotDao = flowerPotDao;
    }
}
