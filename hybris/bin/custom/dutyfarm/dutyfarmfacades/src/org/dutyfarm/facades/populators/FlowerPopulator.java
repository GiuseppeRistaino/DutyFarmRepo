package org.dutyfarm.facades.populators;

import de.hybris.platform.converters.Populator;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import de.hybris.platform.variants.model.VariantProductModel;
import org.apache.log4j.Logger;
import org.dutyfarm.core.model.FlowerProductModel;
import org.dutyfarm.facades.data.FlowerProductData;

public class FlowerPopulator implements Populator<ProductModel, FlowerProductData> {


    private static final Logger LOG = Logger.getLogger(FlowerPopulator.class);

    @Override
    public void populate(ProductModel source, FlowerProductData target) throws ConversionException {
        LOG.info("Invoke method populate in FlowerPopulator");

        final ProductModel baseProduct = getBaseProduct(source);
        if(baseProduct instanceof FlowerProductModel)
        {
            final FlowerProductModel flowerProductModel = (FlowerProductModel) baseProduct;

            if(flowerProductModel.getCode() != null) {
                target.setCode(flowerProductModel.getCode());
            }
            if(flowerProductModel.getName() != null) {
                target.setName(flowerProductModel.getName());
            }
            if(flowerProductModel.getFarmland() != null) {
                target.setFarmland(flowerProductModel.getFarmland());
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
