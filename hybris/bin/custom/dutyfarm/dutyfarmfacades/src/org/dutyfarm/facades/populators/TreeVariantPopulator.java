package org.dutyfarm.facades.populators;

import de.hybris.platform.converters.Populator;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import org.apache.log4j.Logger;
import org.dutyfarm.core.model.TreeVariantProductModel;
import org.dutyfarm.facades.data.TreeVariantProductData;

public class TreeVariantPopulator implements Populator<ProductModel, TreeVariantProductData> {

    private static final Logger LOG = Logger.getLogger(FlowerVariantPopulator.class);

    @Override
    public void populate(ProductModel source, TreeVariantProductData target) throws ConversionException {
        LOG.info("Invoke method populate in TreeVariantPopulator");

        if (source instanceof TreeVariantProductModel){
            final TreeVariantProductModel flowerVariantProductModel = (TreeVariantProductModel) source;

            if(flowerVariantProductModel.getCode() != null) {
                target.setCode(flowerVariantProductModel.getCode());
            }
            if(flowerVariantProductModel.getName() != null) {
                target.setName(flowerVariantProductModel.getName());
            }
            if(flowerVariantProductModel.getEan() != null) {
                target.setEan(flowerVariantProductModel.getEan());
            }
            if(flowerVariantProductModel.getWeight() != null) {
                target.setWeight(flowerVariantProductModel.getWeight());
            }
            if(flowerVariantProductModel.getHeight() != null) {
                target.setHeight(flowerVariantProductModel.getHeight());
            }
            if(flowerVariantProductModel.getScientificName() != null) {
                target.setScientificName(flowerVariantProductModel.getScientificName());
            }
            if(flowerVariantProductModel.getOrigin() != null) {
                target.setOrigin(flowerVariantProductModel.getOrigin());
            }
            if(flowerVariantProductModel.getDiameterStem() != null) {
                target.setDiameterStem(flowerVariantProductModel.getDiameterStem());
            }
        }
    }
}
