package org.dutyfarm.facades.populators;

import de.hybris.platform.converters.Populator;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import de.hybris.platform.variants.model.VariantProductModel;
import org.apache.log4j.Logger;
import org.dutyfarm.core.model.PlantProductModel;
import org.dutyfarm.facades.data.PlantProductData;

public class PlantPopulator implements Populator<ProductModel, PlantProductData> {

    private static final Logger LOG = Logger.getLogger(PlantPopulator.class);

    @Override
    public void populate(ProductModel source, PlantProductData target) throws ConversionException {
        LOG.info("Invoke method populate in PlantPopulator");

        final ProductModel baseProduct = getBaseProduct(source);
        if(baseProduct instanceof PlantProductModel)
        {
            final PlantProductModel plantProductModel = (PlantProductModel) baseProduct;

            if(plantProductModel.getCode() != null) {
                target.setCode(plantProductModel.getCode());
            }
            if(plantProductModel.getName() != null) {
                target.setName(plantProductModel.getName());
            }
            if(plantProductModel.getFarmland() != null) {
                target.setFarmland(plantProductModel.getFarmland());
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
