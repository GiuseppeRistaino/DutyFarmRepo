package org.dutyfarm.facades.populators;

import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import org.apache.log4j.Logger;
import org.dutyfarm.core.model.SeedProductModel;
import org.dutyfarm.facades.data.SeedProductData;

public class SeedReversePopulator implements Populator<SeedProductData, SeedProductModel> {

    private static final Logger LOG = Logger.getLogger(SeedReversePopulator.class);

    @Override
    public void populate(SeedProductData source, SeedProductModel target) throws ConversionException {
        LOG.info("Invoke method populate in SeedReversePopulator");
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
