package org.dutyfarm.facades;


import de.hybris.platform.commercefacades.product.data.ProductData;

import java.util.List;

public interface DutyFarmProductFacade {

    public List<ProductData> getAllProducts();
    public List<ProductData> getAllProductsForCategory(String category);
    public List<ProductData> getAllProductsForName(String name);

}
