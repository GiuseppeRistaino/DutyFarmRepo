package org.dutyfarm.facades.impl;

import de.hybris.platform.servicelayer.dto.converter.Converter;
import org.apache.log4j.Logger;
import org.dutyfarm.core.model.FertilizerProductModel;
import org.dutyfarm.core.model.FlowerPotProductModel;
import org.dutyfarm.core.service.FertilizerService;
import org.dutyfarm.core.service.impl.DefaultFlowerPotService;
import org.dutyfarm.facades.FlowerPotFacade;
import org.dutyfarm.facades.data.FertilizerProductData;
import org.dutyfarm.facades.data.FlowerPotProductData;

import java.util.List;

public class DefaultFlowerPotFacade implements FlowerPotFacade {

    private static final Logger LOG = Logger.getLogger(DefaultFlowerPotFacade.class);

    private DefaultFlowerPotService flowerPotService;

    private Converter<FlowerPotProductModel, FlowerPotProductData> flowerPotConverter;

    @Override
    public List<FlowerPotProductData> getAllFlowerPots() {
        LOG.info("Invoke method getAllFlowerPots in DefaultFlowerPotFacade");
        return flowerPotConverter.convertAll(flowerPotService.getAllFlowerPots());
    }

    public void setFlowerPotService(DefaultFlowerPotService flowerPotService) {
        this.flowerPotService = flowerPotService;
    }

    public void setFlowerPotConverter(Converter<FlowerPotProductModel, FlowerPotProductData> flowerPotConverter) {
        this.flowerPotConverter = flowerPotConverter;
    }
}
