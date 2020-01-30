package org.dutyfarm.facades.populators;

import de.hybris.platform.converters.Populator;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import de.hybris.platform.variants.model.VariantProductModel;
import org.apache.log4j.Logger;
import org.dutyfarm.core.model.FlowerPotProductModel;
import org.dutyfarm.core.model.SeedProductModel;
import org.dutyfarm.facades.data.SeedProductData;

public class SeedPopulator implements Populator<ProductModel, SeedProductData> {

    private static final Logger LOG = Logger.getLogger(SeedPopulator.class);

    @Override
    public void populate(ProductModel source, SeedProductData target) throws ConversionException {
        LOG.info("Invoke method populate in SeedPopulator");

        final ProductModel baseProduct = getBaseProduct(source);

        if (baseProduct instanceof SeedProductModel)
        {
            final SeedProductModel seedProductModel = (SeedProductModel) baseProduct;
            if(seedProductModel.getCode() != null) {
                target.setCode(seedProductModel.getCode());
            }
            if(seedProductModel.getName() != null) {
                target.setName(seedProductModel.getName());
            }
        }
    }

    protected ProductModel getBaseProduct(final ProductModel productModel)
    {
        ProductModel currentProduct = productModel;
        while (currentProduct instanceof VariantProductModel)
        {
            final VariantProductModel variant = (VariantProductModel) currentProduct;
            currentProduct = variant.getBaseProduct();
        }
        return currentProduct;
    }

}
