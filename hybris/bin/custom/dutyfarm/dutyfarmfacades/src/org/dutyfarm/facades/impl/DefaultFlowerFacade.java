package org.dutyfarm.facades.impl;

import de.hybris.platform.servicelayer.dto.converter.Converter;
import org.apache.log4j.Logger;
import org.dutyfarm.core.model.FlowerProductModel;
import org.dutyfarm.core.service.FlowerService;
import org.dutyfarm.facades.FlowerFacade;
import org.dutyfarm.facades.data.FlowerProductData;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;

public class DefaultFlowerFacade implements FlowerFacade {

    private static final Logger LOG = Logger.getLogger(DefaultFlowerFacade.class);

    private FlowerService flowerService;

    private Converter<FlowerProductModel, FlowerProductData> flowerConverter;

    @Override
    public List<FlowerProductData> getAllFlowers() {
        LOG.info("Invoke method getAllFlowers in DefaultFlowerFacade");

        return flowerConverter.convertAll(flowerService.getAllFlowers());
    }

    @Required
    public void setFlowerService(FlowerService flowerService) {
        this.flowerService = flowerService;
    }

    @Required
    public void setFlowerConverter(Converter<FlowerProductModel, FlowerProductData> flowerConverter) {
        this.flowerConverter = flowerConverter;
    }
}
