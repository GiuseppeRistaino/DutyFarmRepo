package org.dutyfarm.core.dao;

import de.hybris.platform.category.model.CategoryModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.internal.dao.GenericDao;

import java.util.List;

public interface DutyFarmProductDao extends GenericDao<ProductModel> {

    public List<ProductModel> findAllProducts(int start, int count);
    public Integer countAllProducts();
    public List<ProductModel> findAllProductsForCategory(CategoryModel category, int start, int count);
    public Integer countAllProductsForCategory(CategoryModel category);
    public List<ProductModel> findAllProductsForName(String name, int start, int count);
    public Integer countAllProductsForName(String name);

}
