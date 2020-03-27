package org.dutyfarm.facades.impl;

import de.hybris.platform.category.CategoryService;
import de.hybris.platform.category.model.CategoryModel;
import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import org.apache.log4j.Logger;
import org.dutyfarm.core.service.DutyFarmProductService;
import org.dutyfarm.core.service.impl.DefaultDutyFarmProductService;
import org.dutyfarm.facades.DutyFarmProductFacade;
import org.dutyfarm.facades.data.DutyFarmCategoryData;

import javax.annotation.Resource;
import java.util.List;

public class DefaultDutyFarmProductFacade implements DutyFarmProductFacade {

    private static final Logger LOG = Logger.getLogger(DefaultDutyFarmProductFacade.class);

    @Resource(name = "dutyFarmProductService")
    private DutyFarmProductService dutyFarmProductService;

    @Resource(name = "dutyFarmProductConverter")
    private Converter<ProductModel, ProductData> dutyFarmProductConverter;

    @Resource(name = "dutyFarmCategoryConverter")
    Converter<CategoryModel, DutyFarmCategoryData> dutyFarmCategoryConverter;

    @Resource(name = "categoryService")
    CategoryService categoryService;

    @Override
    public List<ProductData> getAllProducts(int start, int count) {
        return dutyFarmProductConverter.convertAll(dutyFarmProductService.getAllProducts(start, count));
    }

    @Override
    public List<ProductData> getAllProductsForCategory(String category, int start, int count) {
        CategoryModel categoryModel = categoryService.getCategoryForCode(category);
        return dutyFarmProductConverter.convertAll(dutyFarmProductService.getAllProductsForCategory(categoryModel, start, count));
    }

    @Override
    public List<ProductData> getAllProductsForName(String name, int start, int count) {
        return dutyFarmProductConverter.convertAll(dutyFarmProductService.getAllProductsForName(name, start, count));
    }
}
