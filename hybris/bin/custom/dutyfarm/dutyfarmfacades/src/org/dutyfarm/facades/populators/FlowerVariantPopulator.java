package org.dutyfarm.facades.populators;

import de.hybris.platform.converters.Populator;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import org.apache.log4j.Logger;
import org.dutyfarm.core.enums.SwatchColorEnum;
import org.dutyfarm.core.model.FlowerVariantProductModel;
import org.dutyfarm.facades.data.FlowerVariantProductData;
import org.dutyfarm.facades.data.SwatchColorData;
import org.springframework.beans.factory.annotation.Required;

public class FlowerVariantPopulator implements Populator<ProductModel, FlowerVariantProductData> {

    private static final Logger LOG = Logger.getLogger(FlowerVariantPopulator.class);

    private Converter<SwatchColorEnum, SwatchColorData> swatchColorConverter;

    @Override
    public void populate(ProductModel source, FlowerVariantProductData target) throws ConversionException {
        LOG.info("Invoke method populate in FlowerVariantPopulator");

        if (source instanceof FlowerVariantProductModel){
            final FlowerVariantProductModel flowerVariantProductModel = (FlowerVariantProductModel) source;
            
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
            if(flowerVariantProductModel.getColor() != null) {
                target.setColor(swatchColorConverter.convert(flowerVariantProductModel.getColor()));
            }
            if(flowerVariantProductModel.getHeight() != null) {
                target.setHeight(flowerVariantProductModel.getHeight());
            }
            if(flowerVariantProductModel.getScientificName() != null) {
                target.setScientificName(flowerVariantProductModel.getScientificName());
            }
        }
    }

    @Required
    public void setSwatchColorConverter(Converter<SwatchColorEnum, SwatchColorData> swatchColorConverter) {
        this.swatchColorConverter = swatchColorConverter;
    }
}
