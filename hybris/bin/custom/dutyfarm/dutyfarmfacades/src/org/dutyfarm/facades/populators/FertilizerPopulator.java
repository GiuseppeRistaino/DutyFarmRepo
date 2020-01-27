package org.dutyfarm.facades.populators;

import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import org.apache.log4j.Logger;
import org.dutyfarm.core.model.FertilizerProductModel;
import org.dutyfarm.facades.data.FertilizerProductData;

public class FertilizerPopulator implements Populator<FertilizerProductModel, FertilizerProductData> {

    private static final Logger LOG = Logger.getLogger(FertilizerPopulator.class);

    @Override
    public void populate(FertilizerProductModel source, FertilizerProductData target) throws ConversionException {
        LOG.info("Invoke method populate in FertilizerPopulator");
        if(source.getCode() != null)
        {
            target.setCode(source.getCode());
        }
        if(source.getName() != null)
        {
            target.setName(source.getName());
        }
        if(source.getEan() != null)
        {
            target.setEan(source.getEan());
        }
    }

}
