package org.dutyfarm.core.service.impl;

import org.apache.log4j.Logger;
import org.dutyfarm.core.dao.FlowerPotDao;
import org.dutyfarm.core.dao.FlowerPotVariantDao;
import org.dutyfarm.core.model.FlowerPotVariantProductModel;
import org.dutyfarm.core.service.FlowerPotVariantService;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;

public class DefaultFlowerPotVariantService implements FlowerPotVariantService {

    private static final Logger LOG = Logger.getLogger(DefaultFlowerPotVariantService.class);
    private FlowerPotVariantDao flowerPotVariantDao;

    @Override
    public List<FlowerPotVariantProductModel> getFlowerPotForMaterial(String material) {
        LOG.info("Invoke method getFlowerPotForMaterial in DefaultFlowerPotVariantService");
        return flowerPotVariantDao.findFlowerPotByMaterial(material);
    }

    @Required
    public void setFlowerPotVariantDao(FlowerPotVariantDao flowerPotVariantDao) {
        this.flowerPotVariantDao = flowerPotVariantDao;
    }
}
