package org.dutyfarm.core.service.impl;

import org.apache.log4j.Logger;
import org.dutyfarm.core.dao.FlowerDao;
import org.dutyfarm.core.model.FlowerProductModel;
import org.dutyfarm.core.service.FlowerService;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;

public class DefaultFlowerService implements FlowerService {

    private static final Logger LOG = Logger.getLogger(DefaultFlowerService.class);
    private FlowerDao flowerDao;

    @Override
    public List<FlowerProductModel> getAllFlowers() {
        LOG.info("Invoke method getAllFlowers in DefaultFlowerService");
        return flowerDao.findAllFlowers();
    }

    @Required
    public void setFlowerDao(FlowerDao flowerDao) {
        this.flowerDao = flowerDao;
    }
}
