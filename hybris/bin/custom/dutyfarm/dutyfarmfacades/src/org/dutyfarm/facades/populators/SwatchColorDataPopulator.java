package org.dutyfarm.facades.populators;

import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import de.hybris.platform.servicelayer.type.TypeService;
import org.dutyfarm.core.enums.SwatchColorEnum;
import org.dutyfarm.facades.data.SwatchColorData;
import org.springframework.beans.factory.annotation.Required;

public class SwatchColorDataPopulator implements Populator<SwatchColorEnum, SwatchColorData> {

    private TypeService typeService;

    protected TypeService getTypeService()
    {
        return typeService;
    }

    @Required
    public void setTypeService(final TypeService typeService)
    {
        this.typeService = typeService;
    }

    @Override
    public void populate(SwatchColorEnum source, SwatchColorData target) throws ConversionException {
        target.setCode(source.getCode());
        target.setName(getTypeService().getEnumerationValue(source).getName());
    }
}
