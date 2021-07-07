package org.dutyfarm.facades.impl;

import de.hybris.platform.servicelayer.dto.converter.Converter;
import org.apache.log4j.Logger;
import org.dutyfarm.core.model.VegetableVariantProductModel;
import org.dutyfarm.core.service.VegetableVariantService;
import org.dutyfarm.facades.VegetableVariantFacade;
import org.dutyfarm.facades.data.VegetableVariantProductData;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;

public class DefaultVegetableVariantFacade implements VegetableVariantFacade {

    private static final Logger LOG = Logger.getLogger(DefaultVegetableVariantFacade.class);

    private VegetableVariantService vegetableVariantService;

    private Converter<VegetableVariantProductModel, VegetableVariantProductData> vegetableVariantConverter;

    @Override
    public List<VegetableVariantProductData> getVegetablesForFarmingDifficulty(int farmingDifficulty) {
        LOG.info("Invoke method getVegetablesForFarmingDifficulty in DefaultVegetableVariantFacade");

        return vegetableVariantConverter.convertAll(vegetableVariantService.getVegetablesForFarmingDifficulty(farmingDifficulty));
    }

    @Required
    public void setVegetableVariantService(VegetableVariantService vegetableVariantService) {
        this.vegetableVariantService = vegetableVariantService;
    }

    @Required
    public void setVegetableVariantConverter(Converter<VegetableVariantProductModel, VegetableVariantProductData> vegetableVariantConverter) {
        this.vegetableVariantConverter = vegetableVariantConverter;
    }
}
