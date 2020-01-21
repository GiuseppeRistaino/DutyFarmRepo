package org.dutyfarm.core.service.impl;

import org.apache.log4j.Logger;
import org.dutyfarm.core.dao.SeedVariantDao;
import org.dutyfarm.core.model.SeedVariantProductModel;
import org.dutyfarm.core.service.SeedVariantService;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;

public class DefaultSeedVariantService implements SeedVariantService {

    private static final Logger LOG = Logger.getLogger(DefaultSeedVariantService.class);
    private SeedVariantDao seedVariantDao;

    @Override
    public List<SeedVariantProductModel> getSeedsForOrigin(String origin) {
        LOG.info("Invoke method getSeedsForOrigin in DefaultSeedVariantService");
        return seedVariantDao.findSeedsByOrigin(origin);
    }

    @Required
    public void setSeedVariantDao(SeedVariantDao seedVariantDao) {
        this.seedVariantDao = seedVariantDao;
    }
}
