package org.dutyfarm.facades.impl;

import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import org.apache.log4j.Logger;
import org.dutyfarm.core.service.DutyFarmProductService;
import org.dutyfarm.core.service.impl.DefaultDutyFarmProductService;
import org.dutyfarm.facades.DutyFarmProductFacade;

import javax.annotation.Resource;
import java.util.List;

public class DefaultDutyFarmProductFacade implements DutyFarmProductFacade {

    private static final Logger LOG = Logger.getLogger(DefaultDutyFarmProductFacade.class);

    @Resource(name = "dutyFarmProductService")
    private DutyFarmProductService dutyFarmProductService;

    @Resource(name = "dutyFarmProductConverter")
    private Converter<ProductModel, ProductData> dutyFarmProductConverter;

    @Override
    public List<ProductData> getAllProducts() {
        return dutyFarmProductConverter.convertAll(dutyFarmProductService.getAllProducts());
    }

    @Override
    public List<ProductData> getAllProductsForCategory(String category) {
        return dutyFarmProductConverter.convertAll(dutyFarmProductService.getAllProductsForCategory(category));
    }

    @Override
    public List<ProductData> getAllProductsForName(String name) {
        return dutyFarmProductConverter.convertAll(dutyFarmProductService.getAllProductsForName(name));
    }
}
