package org.dutyfarm.facades.populators;

import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import org.apache.log4j.Logger;
import org.dutyfarm.core.enums.SwatchColorEnum;
import org.dutyfarm.core.model.FertilizerVariantProductModel;
import org.dutyfarm.facades.data.FertilizerVariantProductData;

public class FertilizerVariantPopulator implements Populator<FertilizerVariantProductModel, FertilizerVariantProductData> {

    private static final Logger LOG = Logger.getLogger(FertilizerVariantPopulator.class);

    @Override
    public void populate(FertilizerVariantProductModel source, FertilizerVariantProductData target) throws ConversionException {
        LOG.info("Invoke method populate in FertilizerVariantPopulator");
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
