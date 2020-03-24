package org.dutyfarm.core.service;

import de.hybris.platform.core.model.product.ProductModel;

import java.util.List;

public interface DutyFarmProductService {

    public List<ProductModel> getAllProducts();

    public List<ProductModel> getAllProductsForCategory(String category);

    public List<ProductModel> getAllProductsForName(String name);

}
