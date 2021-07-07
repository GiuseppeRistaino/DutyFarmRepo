package org.dutyfarm.facades.impl;

import de.hybris.platform.servicelayer.dto.converter.Converter;
import org.apache.log4j.Logger;
import org.dutyfarm.core.model.FlowerVariantProductModel;
import org.dutyfarm.core.service.FlowerVariantService;
import org.dutyfarm.facades.FlowerVariantFacade;
import org.dutyfarm.facades.data.FlowerVariantProductData;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;

public class DefaultFlowerVariantFacade implements FlowerVariantFacade {

    private static final Logger LOG = Logger.getLogger(DefaultFlowerVariantFacade.class);

    private FlowerVariantService flowerVariantService;

    private Converter<FlowerVariantProductModel, FlowerVariantProductData> flowerVariantConverter;

    @Override
    public List<FlowerVariantProductData> getFlowersForColor(String color) {

        LOG.info("Invoke method getFlowersForColor in DefaultFlowerVariantFacade");
        return flowerVariantConverter.convertAll(flowerVariantService.getFlowersForColor(color));
    }

    @Required
    public void setFlowerVariantService(FlowerVariantService flowerVariantService) {
        this.flowerVariantService = flowerVariantService;
    }

    @Required
    public void setFlowerVariantConverter(Converter<FlowerVariantProductModel, FlowerVariantProductData> flowerVariantConverter) {
        this.flowerVariantConverter = flowerVariantConverter;
    }
}
