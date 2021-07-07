package org.dutyfarm.core.service.impl;

import org.apache.log4j.Logger;
import org.dutyfarm.core.dao.VegetableDao;
import org.dutyfarm.core.model.VegetableProductModel;
import org.dutyfarm.core.service.VegetableService;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;

public class DefaultVegetableService implements VegetableService {

    private static final Logger LOG = Logger.getLogger(DefaultVegetableService.class);
    private VegetableDao vegetableDao;

    @Override
    public List<VegetableProductModel> getAllVegetables() {
        LOG.info("Invoke method getAllVegetables in DefaultVegetableService");
        return vegetableDao.findAllVegetables();
    }

    @Required
    public void setVegetableDao(VegetableDao vegetableDao) {
        this.vegetableDao = vegetableDao;
    }
}
