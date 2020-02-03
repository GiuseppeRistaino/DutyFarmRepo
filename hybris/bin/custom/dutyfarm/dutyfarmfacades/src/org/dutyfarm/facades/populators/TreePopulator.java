package org.dutyfarm.facades.populators;

import com.thoughtworks.xstream.converters.ConversionException;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.variants.model.VariantProductModel;
import org.apache.log4j.Logger;
import org.dutyfarm.core.model.TreeProductModel;
import org.dutyfarm.facades.data.TreeProductData;

public class TreePopulator implements Populator<ProductModel, TreeProductData> {

    private static final Logger LOG = Logger.getLogger(TreePopulator.class);

    @Override
    public void populate(ProductModel source, TreeProductData target) throws ConversionException {
        LOG.info("Invoke method populate in TreePopulator");

        final ProductModel baseProduct = getBaseProduct(source);
        if(baseProduct instanceof TreeProductModel)
        {
            final TreeProductModel treeProductModel = (TreeProductModel) baseProduct;

            if(treeProductModel.getCode() != null) {
                target.setCode(treeProductModel.getCode());
            }
            if(treeProductModel.getName() != null) {
                target.setName(treeProductModel.getName());
            }
            if(treeProductModel.getFarmland() != null) {
                target.setFarmland(treeProductModel.getFarmland());
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
