package org.dutyfarm.facades.populators;

import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.core.enums.Gender;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import de.hybris.platform.variants.model.VariantProductModel;
import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.dutyfarm.core.model.ApparelProductModel;
import org.dutyfarm.core.model.FertilizerProductModel;
import org.dutyfarm.facades.data.FertilizerProductData;
import org.dutyfarm.facades.product.data.GenderData;

import java.util.ArrayList;
import java.util.List;

public class FertilizerPopulator implements Populator<ProductModel, FertilizerProductData> {

    private static final Logger LOG = Logger.getLogger(FertilizerPopulator.class);

    @Override
    public void populate(ProductModel source, FertilizerProductData target) throws ConversionException {
        LOG.info("Invoke method populate in FertilizerPopulator");

        final ProductModel baseProduct = getBaseProduct(source);

        if (baseProduct instanceof FertilizerProductModel)
        {
            final FertilizerProductModel fertilizerProductModel = (FertilizerProductModel) baseProduct;
            if(fertilizerProductModel.getCode() != null) {
                target.setCode(fertilizerProductModel.getCode());
            }
            if(fertilizerProductModel.getName() != null) {
                target.setName(fertilizerProductModel.getName());
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
