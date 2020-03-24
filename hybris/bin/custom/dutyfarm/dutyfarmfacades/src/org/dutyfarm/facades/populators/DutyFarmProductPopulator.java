package org.dutyfarm.facades.populators;

import de.hybris.platform.commercefacades.product.converters.populator.ProductPricePopulator;
import de.hybris.platform.commercefacades.product.data.ImageData;
import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.core.model.media.MediaContainerModel;
import de.hybris.platform.core.model.media.MediaModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.europe1.jalo.Europe1PriceFactory;
import de.hybris.platform.europe1.jalo.PriceRow;
import de.hybris.platform.europe1.model.PriceRowModel;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import org.apache.log4j.Logger;
import org.apache.xmlgraphics.image.loader.spi.ImageConverter;
import org.dutyfarm.core.jalo.FertilizerProduct;
import org.dutyfarm.core.model.FertilizerProductModel;
import org.dutyfarm.facades.data.FertilizerProductData;

import javax.annotation.Resource;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;

public class DutyFarmProductPopulator implements Populator<ProductModel, ProductData> {

    private static final Logger LOG = Logger.getLogger(DutyFarmProductPopulator.class);

    @Resource(name = "imageConverter")
    private Converter<MediaModel, ImageData> imageConverter;

    @Resource(name = "productPricePopulator")
    private ProductPricePopulator<ProductModel, ProductData> productPricePopulator;

    @Override
    public void populate(ProductModel source, ProductData target) throws ConversionException {
        LOG.info("Invoke method populate in DutyFarmProductPopulator");

        if(source != null) {

            target.setName(source.getName());
            target.setCode(source.getCode());

            Collection<ImageData> images = new ArrayList<ImageData>();

            for(MediaContainerModel gallery : source.getGalleryImages()) {
                images.addAll(imageConverter.convertAll(gallery.getMedias()));
            }
            productPricePopulator.populate(source, target);
            target.setImages(images);
            //target.setPrice(source.getPric);
        }

    }

}
