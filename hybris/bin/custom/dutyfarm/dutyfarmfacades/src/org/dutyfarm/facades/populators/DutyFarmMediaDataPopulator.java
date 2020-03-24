package org.dutyfarm.facades.populators;

import de.hybris.platform.converters.Populator;
import de.hybris.platform.core.model.media.MediaModel;
import org.apache.log4j.Logger;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import org.dutyfarm.facades.data.DutyFarmMediaData;

import javax.annotation.Resource;


public class DutyFarmMediaDataPopulator implements Populator<MediaModel, DutyFarmMediaData> {

    private static final Logger LOG = Logger.getLogger(FertilizerPopulator.class);

    @Override
    public void populate(MediaModel source, DutyFarmMediaData target) throws ConversionException {
        LOG.info("Invoke method populate in DutyFarmMediaDataPopulator");

        if(source != null) {
            if (source.getCode() != null) {
                target.setCode(source.getCode());
            }
            if(source.getMime() != null) {
                target.setMime(source.getMime());
            }
            if(source.getAltText() != null) {
                target.setAltText(source.getAltText());
            }
            if(source.getURL() != null) {
                target.setUrl(source.getURL());
            }
        }
    }
}
