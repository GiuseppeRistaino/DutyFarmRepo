package org.dutyfarm.core.dao;

import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.internal.dao.GenericDao;

import java.util.List;

public interface DutyFarmProductDao extends GenericDao<ProductModel> {

    public List<ProductModel> findAllProducts();
    public List<ProductModel> findAllProductsForCategory(String category);
    public List<ProductModel> findAllProductsForName(String name);

}
