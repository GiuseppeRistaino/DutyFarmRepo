package org.dutyfarm.core.service.impl;

import org.apache.log4j.Logger;
import org.dutyfarm.core.dao.FlowerDao;
import org.dutyfarm.core.dao.VegetableDao;
import org.dutyfarm.core.dao.VegetableVariantDao;
import org.dutyfarm.core.model.VegetableVariantProductModel;
import org.dutyfarm.core.service.VegetableVariantService;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;

public class DefaultVegetableVariantService implements VegetableVariantService {

    private static final Logger LOG = Logger.getLogger(DefaultVegetableVariantService.class);
    private VegetableVariantDao vegetableVariantDao;

    @Override
    public List<VegetableVariantProductModel> getVegetablesForFarmingDifficulty(int farmingDifficulty) {
        LOG.info("Invoke method getVegetablesForFarmingDifficulty in DefaultVegetableVariantService");
        return vegetableVariantDao.findVegetablesByFarmingDifficulty(farmingDifficulty);
    }

    @Required

    public void setVegetableVariantDao(VegetableVariantDao vegetableVariantDao) {
        this.vegetableVariantDao = vegetableVariantDao;
    }
}
