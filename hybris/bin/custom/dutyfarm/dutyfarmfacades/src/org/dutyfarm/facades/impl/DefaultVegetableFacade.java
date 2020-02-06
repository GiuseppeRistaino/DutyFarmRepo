package org.dutyfarm.facades.impl;

import de.hybris.platform.servicelayer.dto.converter.Converter;
import org.apache.log4j.Logger;
import org.dutyfarm.core.model.VegetableProductModel;
import org.dutyfarm.core.service.VegetableService;
import org.dutyfarm.facades.VegetableFacade;
import org.dutyfarm.facades.data.VegetableProductData;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;

public class DefaultVegetableFacade implements VegetableFacade {

    private static final Logger LOG = Logger.getLogger(DefaultVegetableFacade.class);

    private VegetableService vegetableService;

    private Converter<VegetableProductModel, VegetableProductData> vegetableConverter;

    @Override
    public List<VegetableProductData> getAllVegetables() {

        LOG.info("Invoke method getAllVegetables in DefaultVegetableFacade");
        return vegetableConverter.convertAll(vegetableService.getAllVegetables());
    }

    @Required
    public void setVegetableService(VegetableService vegetableService) {
        this.vegetableService = vegetableService;
    }

    @Required
    public void setVegetableConverter(Converter<VegetableProductModel, VegetableProductData> vegetableConverter) {
        this.vegetableConverter = vegetableConverter;
    }
}
