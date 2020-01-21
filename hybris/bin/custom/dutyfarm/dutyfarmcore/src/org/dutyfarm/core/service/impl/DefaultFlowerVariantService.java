package org.dutyfarm.core.service.impl;

import org.apache.log4j.Logger;
import org.dutyfarm.core.dao.FlowerVariantDao;
import org.dutyfarm.core.dao.TreeVariantDao;
import org.dutyfarm.core.model.FlowerVariantProductModel;
import org.dutyfarm.core.service.FlowerVariantService;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;

public class DefaultFlowerVariantService implements FlowerVariantService {

    private static final Logger LOG = Logger.getLogger(DefaultFlowerVariantService.class);
    private FlowerVariantDao flowerVariantDao;

    @Override
    public List<FlowerVariantProductModel> getFlowersForColor(String color) {
        LOG.info("Invoke method getFlowersForColor in DefaultFlowerVariantService");

        return flowerVariantDao.findFlowersByColor(color);
    }

    @Required
    public void setFlowerVariantDao(FlowerVariantDao flowerVariantDao) {
        this.flowerVariantDao = flowerVariantDao;
    }
}
