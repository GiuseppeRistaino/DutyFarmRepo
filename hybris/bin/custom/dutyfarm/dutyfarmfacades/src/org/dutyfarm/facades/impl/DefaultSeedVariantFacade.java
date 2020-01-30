package org.dutyfarm.facades.impl;

import de.hybris.platform.servicelayer.dto.converter.Converter;
import org.apache.log4j.Logger;
import org.dutyfarm.core.model.SeedProductModel;
import org.dutyfarm.core.model.SeedVariantProductModel;
import org.dutyfarm.core.service.impl.DefaultSeedService;
import org.dutyfarm.core.service.impl.DefaultSeedVariantService;
import org.dutyfarm.facades.SeedVariantFacade;
import org.dutyfarm.facades.data.SeedProductData;
import org.dutyfarm.facades.data.SeedVariantProductData;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;

public class DefaultSeedVariantFacade implements SeedVariantFacade {

    private static final Logger LOG = Logger.getLogger(DefaultSeedVariantFacade.class);

    private DefaultSeedVariantService seedVariantService;

    private Converter<SeedVariantProductModel, SeedVariantProductData> seedVariantConverter;

    @Override
    public List<SeedVariantProductData> getSeedsForOrigin(String origin) {
        LOG.info("Invoke method getSeedsForOrigin in DefaultSeedVariantFacade");
        return seedVariantConverter.convertAll(seedVariantService.getSeedsForOrigin(origin));
    }

    @Required
    public void setSeedVariantService(DefaultSeedVariantService seedVariantService) {
        this.seedVariantService = seedVariantService;
    }

    @Required
    public void setSeedVariantConverter(Converter<SeedVariantProductModel, SeedVariantProductData> seedVariantConverter) {
        this.seedVariantConverter = seedVariantConverter;
    }
}
