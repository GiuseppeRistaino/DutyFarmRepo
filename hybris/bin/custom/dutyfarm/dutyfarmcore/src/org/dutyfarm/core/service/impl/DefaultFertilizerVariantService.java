package org.dutyfarm.core.service.impl;

import org.apache.log4j.Logger;
import org.dutyfarm.core.dao.FertilizerVariantDao;
import org.dutyfarm.core.model.FertilizerVariantProductModel;
import org.dutyfarm.core.service.FertilizerVariantService;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;

public class DefaultFertilizerVariantService implements FertilizerVariantService {

    private static final Logger LOG = Logger.getLogger(DefaultFertilizerVariantService.class);
    private FertilizerVariantDao fertilizerVariantDao;

    @Override
    public List<FertilizerVariantProductModel> getFertilizersForState(String state) {
        LOG.info("Invoke method getFertilizersForState in DefaultFertilizerVariantService");
        return fertilizerVariantDao.findFertilizersByState(state);
    }

    @Required
    public void setFertilizerVariantDao(FertilizerVariantDao fertilizerVariantDao) {
        this.fertilizerVariantDao = fertilizerVariantDao;
    }

}
