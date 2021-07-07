package org.dutyfarm.facades.populators;

import de.hybris.platform.converters.Populator;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import de.hybris.platform.variants.model.VariantProductModel;
import org.apache.log4j.Logger;
import org.dutyfarm.core.model.FlowerPotProductModel;
import org.dutyfarm.facades.data.FlowerPotProductData;

public class FlowerPotPopulator implements Populator<ProductModel, FlowerPotProductData>  {
    
    private static final Logger LOG = Logger.getLogger(FlowerPotPopulator.class);

    @Override
    public void populate(ProductModel source, FlowerPotProductData target) throws ConversionException {
        LOG.info("Invoke method populate in FlowerPotPopulator");

        final ProductModel baseProduct = getBaseProduct(source);

        if (baseProduct instanceof FlowerPotProductModel)
        {
            final FlowerPotProductModel flowerPotProductModel = (FlowerPotProductModel) baseProduct;
            if(flowerPotProductModel.getCode() != null) {
                target.setCode(flowerPotProductModel.getCode());
            }
            if(flowerPotProductModel.getName() != null) {
                target.setName(flowerPotProductModel.getName());
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
