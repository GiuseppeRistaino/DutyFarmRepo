package org.dutyfarm.core.service.impl;

import org.apache.log4j.Logger;
import org.dutyfarm.core.dao.SeedDao;
import org.dutyfarm.core.model.SeedProductModel;
import org.dutyfarm.core.service.SeedService;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;

public class DefaultSeedService implements SeedService {

    private static final Logger LOG = Logger.getLogger(DefaultSeedService.class);
    private SeedDao seedDao;

    @Override
    public List<SeedProductModel> getAllSeeds() {
        LOG.info("Invoke method getAllSeeds in DefaultSeedService");
        return seedDao.findAllSeeds();
    }

    @Required
    public void setSeedDao(SeedDao seedDao) {
        this.seedDao = seedDao;
    }
}
