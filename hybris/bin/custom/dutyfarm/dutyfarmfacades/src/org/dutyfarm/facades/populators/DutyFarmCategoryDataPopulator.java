package org.dutyfarm.facades.populators;

import de.hybris.platform.category.model.CategoryModel;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.core.model.media.MediaModel;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import org.apache.log4j.Logger;
import org.dutyfarm.facades.data.DutyFarmCategoryData;
import org.dutyfarm.facades.data.DutyFarmMediaData;

import javax.annotation.Resource;

public class DutyFarmCategoryDataPopulator implements Populator<CategoryModel, DutyFarmCategoryData> {

    private static final Logger LOG = Logger.getLogger(FertilizerPopulator.class);

    @Resource (name="dutyFarmMediaConverter")
    private Converter<MediaModel, DutyFarmMediaData> dutyFarmMediaConverter;

    @Override
    public void populate(CategoryModel source, DutyFarmCategoryData target) throws ConversionException {

        if(source != null) {
            if (source.getCode() != null) {
                target.setCode(source.getCode());
            }
            if (source.getName() != null) {
                target.setName(source.getName());
            }
            if (source.getPicture() != null) {
                target.setPicture(dutyFarmMediaConverter.convert(source.getPicture()));
            }
            if (source.getThumbnail() != null) {
                target.setThumbnail(dutyFarmMediaConverter.convert(source.getThumbnail()));
            }
        }
    }

}
