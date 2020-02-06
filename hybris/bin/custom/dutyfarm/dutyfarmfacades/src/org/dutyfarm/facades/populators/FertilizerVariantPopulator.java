package org.dutyfarm.facades.populators;

import de.hybris.platform.converters.Populator;
import de.hybris.platform.core.enums.Gender;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import de.hybris.platform.variants.model.VariantProductModel;
import org.apache.log4j.Logger;
import org.dutyfarm.core.enums.StateEnum;
import org.dutyfarm.core.enums.SwatchColorEnum;
import org.dutyfarm.core.model.FertilizerProductModel;
import org.dutyfarm.core.model.FertilizerVariantProductModel;
import org.dutyfarm.facades.data.FertilizerProductData;
import org.dutyfarm.facades.data.FertilizerVariantProductData;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import org.dutyfarm.facades.data.StateData;
import org.dutyfarm.facades.data.SwatchColorData;
import org.dutyfarm.facades.product.data.GenderData;
import org.springframework.beans.factory.annotation.Required;

public class FertilizerVariantPopulator implements Populator<ProductModel, FertilizerVariantProductData> {

    private static final Logger LOG = Logger.getLogger(FertilizerVariantPopulator.class);

    private Converter<SwatchColorEnum, SwatchColorData> swatchColorConverter;
    private Converter<StateEnum, StateData> stateConverter;

    @Override
    public void populate(ProductModel source, FertilizerVariantProductData target) throws ConversionException {
        LOG.info("Invoke method populate in FertilizerVariantPopulator");

        if (source instanceof FertilizerVariantProductModel)
        {
            final FertilizerVariantProductModel fertilizerVariantProductModel = (FertilizerVariantProductModel) source;
            if(fertilizerVariantProductModel.getCode() != null) {
                target.setCode(fertilizerVariantProductModel.getCode());
            }
            if(fertilizerVariantProductModel.getName() != null) {
                target.setName(fertilizerVariantProductModel.getName());
            }
            if(fertilizerVariantProductModel.getEan() != null) {
                target.setEan(fertilizerVariantProductModel.getEan());
            }
            if(fertilizerVariantProductModel.getWeight() != null) {
                target.setWeight(fertilizerVariantProductModel.getWeight());
            }
            if(fertilizerVariantProductModel.getColor() != null) {
                target.setColor(swatchColorConverter.convert(fertilizerVariantProductModel.getColor()));
            }
            if(fertilizerVariantProductModel.getState() != null) {
                target.setState(stateConverter.convert(fertilizerVariantProductModel.getState()));
            }
        }
    }

    @Required
    public void setSwatchColorConverter(Converter<SwatchColorEnum, SwatchColorData> swatchColorConverter) {
        this.swatchColorConverter = swatchColorConverter;
    }

    @Required
    public void setStateConverter(Converter<StateEnum, StateData> stateConverter) {
        this.stateConverter = stateConverter;
    }
}
