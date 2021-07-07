package org.dutyfarm.facades.impl;

import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.category.CategoryService;
import de.hybris.platform.category.model.CategoryModel;
import de.hybris.platform.commercefacades.product.data.CategoryData;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import org.dutyfarm.facades.CategoryFacade;
import org.dutyfarm.facades.data.DutyFarmCategoryData;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DefaultCategoryFacade implements CategoryFacade {

    @Resource(name = "dutyFarmCategoryConverter")
    Converter<CategoryModel, DutyFarmCategoryData> dutyFarmCategoryConverter;

    @Resource(name = "categoryService")
    CategoryService categoryService;

    @Override
    public List<DutyFarmCategoryData> findAllCategoriesForCatalogVersion(CatalogVersionModel catalogVersion) {
        Collection<CategoryModel> rootCategories = categoryService.getRootCategoriesForCatalogVersion(catalogVersion);
        Collection<CategoryModel> temp = new ArrayList<CategoryModel>();
        temp.addAll(rootCategories);
        for(CategoryModel category : rootCategories) {
            temp.addAll(category.getAllSubcategories());
        }
        return dutyFarmCategoryConverter.convertAll(temp);
    }



}
