package org.dutyfarm.core.service;

import de.hybris.platform.category.model.CategoryModel;
import de.hybris.platform.core.model.product.ProductModel;

import java.util.List;

public interface DutyFarmProductService {

    public List<ProductModel> getAllProducts(int start, int count);
    public Integer countAllProducts();

    public List<ProductModel> getAllProductsForCategory(CategoryModel category, int start, int count);
    public Integer countAllProductsForCategory(CategoryModel category);

    public List<ProductModel> getAllProductsForName(String name, int start, int count);
    public Integer countAllProductsForName(String name);

}
