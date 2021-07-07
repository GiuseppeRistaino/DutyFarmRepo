package org.dutyfarm.facades.populators;

import de.hybris.platform.converters.Populator;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import de.hybris.platform.variants.model.VariantProductModel;
import org.apache.log4j.Logger;
import org.dutyfarm.core.enums.SwatchColorEnum;
import org.dutyfarm.core.model.FertilizerVariantProductModel;
import org.dutyfarm.core.model.FlowerPotVariantProductModel;
import org.dutyfarm.facades.data.FlowerPotVariantProductData;
import org.dutyfarm.facades.data.SwatchColorData;
import org.springframework.beans.factory.annotation.Required;

public class FlowerPotVariantPopulator implements Populator<ProductModel, FlowerPotVariantProductData> {

    private static final Logger LOG = Logger.getLogger(FlowerPotVariantPopulator.class);

    private Converter<SwatchColorEnum, SwatchColorData> swatchColorConverter;

    @Override
    public void populate(ProductModel source, FlowerPotVariantProductData target) throws ConversionException {
        LOG.info("Invoke method populate in FlowerPotVariantPopulator");

        if (source instanceof FlowerPotVariantProductModel)
        {
            final FlowerPotVariantProductModel flowerPotVariantProductModel = (FlowerPotVariantProductModel) source;
            if(flowerPotVariantProductModel.getCode() != null) {
                target.setCode(flowerPotVariantProductModel.getCode());
            }
            if(flowerPotVariantProductModel.getName() != null) {
                target.setName(flowerPotVariantProductModel.getName());
            }
            if(flowerPotVariantProductModel.getEan() != null) {
                target.setEan(flowerPotVariantProductModel.getEan());
            }
            if(flowerPotVariantProductModel.getDepth() != null) {
                target.setDepth(flowerPotVariantProductModel.getDepth());
            }
            if(flowerPotVariantProductModel.getColor() != null) {
                target.setColor(swatchColorConverter.convert(flowerPotVariantProductModel.getColor()));
            }
            if(flowerPotVariantProductModel.getForm() != null) {
                target.setForm(flowerPotVariantProductModel.getForm());
            }
            if(flowerPotVariantProductModel.getHeight() != null) {
                target.setHeight(flowerPotVariantProductModel.getHeight());
            }
            if(flowerPotVariantProductModel.getMaterial() != null) {
                target.setMaterial(flowerPotVariantProductModel.getMaterial());
            }
            if(flowerPotVariantProductModel.getWidth() != null) {
                target.setWidth(flowerPotVariantProductModel.getWidth());
            }
        }
    }

    @Required
    public void setSwatchColorConverter(Converter<SwatchColorEnum, SwatchColorData> swatchColorConverter) {
        this.swatchColorConverter = swatchColorConverter;
    }
}
