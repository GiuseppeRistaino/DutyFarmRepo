package org.dutyfarm.core.service.impl;

import org.apache.log4j.Logger;
import org.dutyfarm.core.dao.FertilizerDao;
import org.dutyfarm.core.model.FertilizerProductModel;
import org.dutyfarm.core.service.FertilizerService;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;

public class DefaultFertilizerService implements FertilizerService {

    private static final Logger LOG = Logger.getLogger(DefaultFertilizerService.class);
    private FertilizerDao fertilizerDao;

    @Override
    public List<FertilizerProductModel> getAllFertilizers() {
        LOG.info("Invoke method getAllFertilizers in DefaultFertilizerService");
        return fertilizerDao.findAllFertilizers();
    }

    @Required
    public void setFertilizerDao(FertilizerDao fertilizerDao) {
        this.fertilizerDao = fertilizerDao;
    }
}
