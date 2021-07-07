package org.dutyfarm.facades.impl;


import de.hybris.platform.servicelayer.dto.converter.Converter;
import org.apache.log4j.Logger;
import org.dutyfarm.core.model.FertilizerProductModel;
import org.dutyfarm.core.model.FertilizerVariantProductModel;
import org.dutyfarm.core.service.FertilizerService;
import org.dutyfarm.core.service.FertilizerVariantService;
import org.dutyfarm.facades.data.FertilizerProductData;
import org.dutyfarm.facades.data.FertilizerVariantProductData;
import org.dutyfarm.facades.FertilizerVariantFacade;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;

public class DefaultFertilizerVariantFacade implements FertilizerVariantFacade {

    private static final Logger LOG = Logger.getLogger(DefaultFertilizerVariantFacade.class);

    private FertilizerVariantService fertilizerVariantService;

    private Converter<FertilizerVariantProductModel, FertilizerVariantProductData> fertilizerVariantConverter;

    @Override
    public List<FertilizerVariantProductData> getFertilizersForState(String state) {
        LOG.info("Invoke method getFertilizersForState in DefaultFertilizerVariantFacade");
        return fertilizerVariantConverter.convertAll(fertilizerVariantService.getFertilizersForState(state));
    }

    @Required
    public void setFertilizerVariantService(FertilizerVariantService fertilizerVariantService) {
        this.fertilizerVariantService = fertilizerVariantService;
    }

    @Required
    public void setFertilizerVariantConverter(Converter<FertilizerVariantProductModel, FertilizerVariantProductData> fertilizerVariantConverter) {
        this.fertilizerVariantConverter = fertilizerVariantConverter;
    }
}
