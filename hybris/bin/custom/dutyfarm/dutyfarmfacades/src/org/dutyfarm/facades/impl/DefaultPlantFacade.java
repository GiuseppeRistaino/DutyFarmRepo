package org.dutyfarm.facades.impl;

import de.hybris.platform.servicelayer.dto.converter.Converter;
import org.apache.log4j.Logger;
import org.dutyfarm.core.model.PlantProductModel;
import org.dutyfarm.core.service.PlantService;
import org.dutyfarm.facades.PlantFacade;
import org.dutyfarm.facades.data.PlantProductData;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;

public class DefaultPlantFacade implements PlantFacade {

    private static final Logger LOG = Logger.getLogger(DefaultPlantFacade.class);

    private PlantService plantService;

    private Converter<PlantProductModel, PlantProductData> plantConverter;

    @Override
    public List<PlantProductData> getAllPlants() {
        LOG.info("Invoke method getAllPlants in DefaultPlantFacade");

        return plantConverter.convertAll(plantService.getAllPlants());
    }

    @Required
    public void setPlantService(PlantService plantService) {
        this.plantService = plantService;
    }

    @Required
    public void setPlantConverter(Converter<PlantProductModel, PlantProductData> plantConverter) {
        this.plantConverter = plantConverter;
    }
}
