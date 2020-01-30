package org.dutyfarm.facades.populators;

import de.hybris.platform.converters.Populator;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import de.hybris.platform.variants.model.VariantProductModel;
import org.apache.log4j.Logger;
import org.dutyfarm.core.model.FlowerPotVariantProductModel;
import org.dutyfarm.core.model.SeedProductModel;
import org.dutyfarm.core.model.SeedVariantProductModel;
import org.dutyfarm.facades.data.SeedVariantProductData;

public class SeedVariantPopulator implements Populator<ProductModel, SeedVariantProductData> {

    private static final Logger LOG = Logger.getLogger(SeedVariantPopulator.class);

    @Override
    public void populate(ProductModel source, SeedVariantProductData target) throws ConversionException {
        LOG.info("Invoke method populate in SeedVariantPopulator");

        if (source instanceof SeedVariantProductModel)
        {
            final SeedVariantProductModel seedVariantProductModel = (SeedVariantProductModel) source;
            if(seedVariantProductModel.getCode() != null) {
                target.setCode(seedVariantProductModel.getCode());
            }
            if(seedVariantProductModel.getName() != null) {
                target.setName(seedVariantProductModel.getName());
            }
            if(seedVariantProductModel.getEan() != null) {
                target.setEan(seedVariantProductModel.getEan());
            }
            if(seedVariantProductModel.getWeight() != null) {
                target.setWeight(seedVariantProductModel.getWeight());
            }
        }

    }


}
