package org.dutyfarm.facades.populators;

import de.hybris.platform.converters.Populator;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import org.apache.log4j.Logger;
import org.dutyfarm.core.enums.SwatchColorEnum;
import org.dutyfarm.core.model.VegetableVariantProductModel;
import org.dutyfarm.facades.data.SwatchColorData;
import org.dutyfarm.facades.data.VegetableVariantProductData;
import org.springframework.beans.factory.annotation.Required;

public class VegetableVariantPopulator implements Populator<ProductModel, VegetableVariantProductData> {

    private static final Logger LOG = Logger.getLogger(VegetableVariantPopulator.class);

    private Converter<SwatchColorEnum, SwatchColorData> swatchColorConverter;


    @Override
    public void populate(ProductModel source, VegetableVariantProductData target) throws ConversionException {

        LOG.info("Invoke method populate in VegetableVariantPopulator");

        if (source instanceof VegetableVariantProductModel){
            final VegetableVariantProductModel vegetableVariantProductModel = (VegetableVariantProductModel) source;

            if(vegetableVariantProductModel.getCode() != null) {
                target.setCode(vegetableVariantProductModel.getCode());
            }
            if(vegetableVariantProductModel.getName() != null) {
                target.setName(vegetableVariantProductModel.getName());
            }
            if(vegetableVariantProductModel.getEan() != null) {
                target.setEan(vegetableVariantProductModel.getEan());
            }
            if(vegetableVariantProductModel.getWeight() != null) {
                target.setWeight(vegetableVariantProductModel.getWeight());
            }
            if(vegetableVariantProductModel.getScientificName() != null) {
                target.setScientificName(vegetableVariantProductModel.getScientificName());
            }
            if(vegetableVariantProductModel.getFarmingDifficulty() != null){
                target.setFarmingDifficulty(vegetableVariantProductModel.getScientificName());
            }
            if(vegetableVariantProductModel.getVegetableColor() != null){
                target.setVegetableColor(swatchColorConverter.convert(vegetableVariantProductModel.getVegetableColor()));
            }
        }
    }

    @Required
    public void setSwatchColorConverter(Converter<SwatchColorEnum, SwatchColorData> swatchColorConverter) {
        this.swatchColorConverter = swatchColorConverter;
    }
}
