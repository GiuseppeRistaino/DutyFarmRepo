package org.dutyfarm.facades.populators;

import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import org.apache.log4j.Logger;
import org.dutyfarm.core.model.FlowerPotProductModel;
import org.dutyfarm.facades.data.FlowerPotProductData;

public class FlowerPotPopulator implements Populator<FlowerPotProductModel, FlowerPotProductData> {
    
    private static final Logger LOG = Logger.getLogger(FlowerPotPopulator.class);

    @Override
    public void populate(FlowerPotProductModel source, FlowerPotProductData target) throws ConversionException {
        LOG.info("Invoke method populate in FlowerPotPopulator");
        if(source.getCode() != null) 
        {
            target.setCode(source.getCode());   
        }
        if(source.getEan() != null) 
        {
            target.setEan(source.getEan());
        }
        if(source.getName() != null) 
        {
            target.setName(source.getName());
        }
    }
    
}
