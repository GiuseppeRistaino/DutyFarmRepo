package org.dutyfarm.facades.impl;

import de.hybris.platform.servicelayer.dto.converter.Converter;
import org.apache.log4j.Logger;
import org.dutyfarm.core.model.FlowerPotProductModel;
import org.dutyfarm.core.model.SeedProductModel;
import org.dutyfarm.core.service.impl.DefaultFlowerPotService;
import org.dutyfarm.core.service.impl.DefaultSeedService;
import org.dutyfarm.facades.SeedFacade;
import org.dutyfarm.facades.data.FlowerPotProductData;
import org.dutyfarm.facades.data.SeedProductData;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;

public class DefaultSeedFacade implements SeedFacade {

    private static final Logger LOG = Logger.getLogger(DefaultSeedFacade.class);

    private DefaultSeedService seedService;

    private Converter<SeedProductModel, SeedProductData> seedConverter;

    @Override
    public List<SeedProductData> getAllSeeds() {
        LOG.info("Invoke method getAllSeeds in DefaultSeedFacade");
        return seedConverter.convertAll(seedService.getAllSeeds());
    }

    @Required
    public void setSeedService(DefaultSeedService seedService) {
        this.seedService = seedService;
    }

    @Required
    public void setSeedConverter(Converter<SeedProductModel, SeedProductData> seedConverter) {
        this.seedConverter = seedConverter;
    }
}
