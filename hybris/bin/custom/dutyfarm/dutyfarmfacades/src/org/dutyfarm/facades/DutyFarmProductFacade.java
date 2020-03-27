package org.dutyfarm.facades;


import de.hybris.platform.commercefacades.product.data.ProductData;

import java.util.List;

public interface DutyFarmProductFacade {

    public List<ProductData> getAllProducts(int start, int count);
    public List<ProductData> getAllProductsForCategory(String category, int start, int count);
    public List<ProductData> getAllProductsForName(String name, int start, int count);

}
