package org.dutyfarm.facades.populators;

import com.thoughtworks.xstream.converters.ConversionException;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.variants.model.VariantProductModel;
import org.apache.log4j.Logger;
import org.dutyfarm.core.model.VegetableProductModel;
import org.dutyfarm.facades.data.VegetableProductData;

public class VegetablePopulator implements Populator<ProductModel, VegetableProductData> {

    private static final Logger LOG = Logger.getLogger(VegetablePopulator.class);

    @Override
    public void populate(ProductModel source, VegetableProductData target) throws ConversionException {
        LOG.info("Invoke method populate in VegetablePopulator");

        final ProductModel baseProduct = getBaseProduct(source);
        if(baseProduct instanceof VegetableProductModel)
        {
            final VegetableProductModel vegetableProductModel = (VegetableProductModel) baseProduct;

            if(vegetableProductModel.getCode() != null) {
                target.setCode(vegetableProductModel.getCode());
            }
            if(vegetableProductModel.getName() != null) {
                target.setName(vegetableProductModel.getName());
            }
            if(vegetableProductModel.getFarmland() != null) {
                target.setFarmland(vegetableProductModel.getFarmland());
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
