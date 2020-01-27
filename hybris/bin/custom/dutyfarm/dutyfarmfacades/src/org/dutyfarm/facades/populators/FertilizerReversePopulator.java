package org.dutyfarm.facades.populators;

import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import org.apache.log4j.Logger;
import org.dutyfarm.core.model.FertilizerProductModel;
import org.dutyfarm.facades.data.FertilizerProductData;

public class FertilizerReversePopulator implements Populator<FertilizerProductData, FertilizerProductModel> {

    private static final Logger LOG = Logger.getLogger(FertilizerReversePopulator.class);

    @Override
    public void populate(FertilizerProductData source, FertilizerProductModel target) throws ConversionException {
        LOG.info("Invoke method populate in FertilizerReversePopulator");
        if(source.getCode()!= null)
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
