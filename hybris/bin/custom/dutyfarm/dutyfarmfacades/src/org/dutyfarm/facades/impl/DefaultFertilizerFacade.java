package org.dutyfarm.facades.impl;

import de.hybris.platform.servicelayer.dto.converter.Converter;
import org.apache.log4j.Logger;
import org.dutyfarm.core.model.FertilizerProductModel;
import org.dutyfarm.core.service.FertilizerService;
import org.dutyfarm.facades.FertilizerFacade;
import org.dutyfarm.facades.data.FertilizerProductData;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;

public class DefaultFertilizerFacade implements FertilizerFacade {

    private static final Logger LOG = Logger.getLogger(DefaultFertilizerFacade.class);

    private FertilizerService fertilizerService;

    private Converter<FertilizerProductModel, FertilizerProductData> fertilizerConverter;

    @Override
    public List<FertilizerProductData> getAllFertilizers() {
        LOG.info("Invoke method getAllFertilizers in DefaultFertilizerFacade");
        return fertilizerConverter.convertAll(fertilizerService.getAllFertilizers());
    }

    @Required
    public void setFertilizerService(FertilizerService fertilizerService) {
        this.fertilizerService = fertilizerService;
    }

    @Required
    public void setFertilizerConverter(Converter<FertilizerProductModel, FertilizerProductData> fertilizerConverter) {
        this.fertilizerConverter = fertilizerConverter;
    }
}
