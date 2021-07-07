package org.dutyfarm.facades;

import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.commercefacades.product.data.CategoryData;
import org.dutyfarm.facades.data.DutyFarmCategoryData;

import java.util.List;

public interface CategoryFacade {

    List<DutyFarmCategoryData> findAllCategoriesForCatalogVersion(CatalogVersionModel catalogVersion);

}
