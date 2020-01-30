package org.dutyfarm.facades.impl;

import de.hybris.platform.servicelayer.dto.converter.Converter;
import org.apache.log4j.Logger;
import org.dutyfarm.core.model.FlowerPotProductModel;
import org.dutyfarm.core.model.FlowerPotVariantProductModel;
import org.dutyfarm.core.service.impl.DefaultFlowerPotService;
import org.dutyfarm.core.service.impl.DefaultFlowerPotVariantService;
import org.dutyfarm.facades.data.FlowerPotProductData;
import org.dutyfarm.facades.data.FlowerPotVariantProductData;
import org.dutyfarm.facades.FlowerPotVariantFacade;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;

public class DefaultFlowerPotVariantFacade implements FlowerPotVariantFacade {

    private static final Logger LOG = Logger.getLogger(DefaultFlowerPotVariantFacade.class);

    private DefaultFlowerPotVariantService flowerPotVariantService;

    private Converter<FlowerPotVariantProductModel, FlowerPotVariantProductData> flowerPotVariantConverter;

    @Override
    public List<FlowerPotVariantProductData> getFlowerPotForMaterial(String material) {
        LOG.info("Invoke method getFlowerPotForMaterial in DefaultFlowerPotVariantFacade");
        return flowerPotVariantConverter.convertAll(flowerPotVariantService.getFlowerPotForMaterial(material));
    }

    @Required
    public void setFlowerPotVariantService(DefaultFlowerPotVariantService flowerPotVariantService) {
        this.flowerPotVariantService = flowerPotVariantService;
    }

    @Required
    public void setFlowerPotVariantConverter(Converter<FlowerPotVariantProductModel, FlowerPotVariantProductData> flowerPotVariantConverter) {
        this.flowerPotVariantConverter = flowerPotVariantConverter;
    }
}
