package org.dutyfarm.facades.populators;

import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import org.apache.log4j.Logger;
import org.dutyfarm.core.model.SeedProductModel;
import org.dutyfarm.facades.data.SeedProductData;

public class SeedPopulator implements Populator<SeedProductModel, SeedProductData> {

    private static final Logger LOG = Logger.getLogger(SeedPopulator.class);

    @Override
    public void populate(SeedProductModel source, SeedProductData target) throws ConversionException {
        LOG.info("Invoke method populate in SeedPopulator");
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
