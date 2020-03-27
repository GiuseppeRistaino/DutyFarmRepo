package org.dutyfarm.storefront.controllers.dutyFarm;

import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.catalog.CatalogVersionService;
import de.hybris.platform.category.CategoryService;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.cms2.model.pages.AbstractPageModel;
import de.hybris.platform.cms2.model.pages.ContentPageModel;
import de.hybris.platform.commercefacades.product.data.ProductData;
import org.apache.log4j.Logger;
import org.dutyfarm.core.service.DutyFarmProductService;
import org.dutyfarm.facades.CategoryFacade;
import org.dutyfarm.facades.DutyFarmProductFacade;
import org.dutyfarm.facades.data.DutyFarmCategoryData;
import org.dutyfarm.storefront.controllers.ControllerConstants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping(value="/shop")
public class ShopController extends AbstractPageController {

    private static final Logger LOG = Logger.getLogger(ShopController.class);

    @Resource(name="dutyFarmProductFacade")
    private DutyFarmProductFacade dutyFarmProductFacade;

    @Resource(name="dutyFarmProductService")
    private DutyFarmProductService dutyFarmProductService;

    @Resource(name="categoryService")
    private CategoryService categoryService;

    @Resource(name="categoryFacade")
    private CategoryFacade categoryFacade;

    @Resource(name="catalogVersionService")
    private CatalogVersionService catalogVersionService;

    private static final int PRODUCTS_FOR_PAGE = 12;
    private static final String DUTY_FARM_PRODUCT_CATALOG = "dutyFarmProductCatalog";
    private static final String DUTY_FARM_CATALOG_VERSION = "Staged";

    @RequestMapping(method = RequestMethod.GET)
    public String searchAllFarmProducts(@RequestParam String category, final Model model, final HttpServletResponse response)
            throws CMSItemNotFoundException {
        LOG.info("Invoke method searchAllFarmProducts in ShopController");

        //Prendiamo le categorie
        List<DutyFarmCategoryData> categories = categoryFacade.findAllCategoriesForCatalogVersion(catalogVersionService.getCatalogVersion
                (DUTY_FARM_PRODUCT_CATALOG, DUTY_FARM_CATALOG_VERSION));

        //Prendiamo il numero totale di prodotti per una data categoria
        dutyFarmProductService.countAllProductsForCategory(categoryService.getCategoryForCode(catalogVersionService.getCatalogVersion
                (DUTY_FARM_PRODUCT_CATALOG, DUTY_FARM_CATALOG_VERSION), category));

        //Prendiamo i prodotti per la categoria selezionata
        final List<ProductData> products = dutyFarmProductFacade.getAllProductsForCategory(category, 0, PRODUCTS_FOR_PAGE);
        if(products == null) {
            LOG.info("List of products is null");
        }
        else {
            LOG.info("Number of elements in list of products: " + products.size());
            LOG.info("Name of the first element: " + products.get(0).getName());
        }

        model.addAttribute("products", products);
        model.addAttribute("categories", categories);

        storeCmsPageInModel(model, getCmsPage());
        setUpMetaDataForContentPage(model, (ContentPageModel) getCmsPage());
        updatePageTitle(model, getContentPageForLabelOrId(null));

        return ControllerConstants.Views.Pages.DutyFarm.DutyFarmFarmPage;
    }

    protected void updatePageTitle(final Model model, final AbstractPageModel cmsPage)
    {
        storeContentPageTitleInModel(model, getPageTitleResolver().resolveHomePageTitle(cmsPage.getTitle()));
    }

    protected AbstractPageModel getCmsPage() throws CMSItemNotFoundException
    {
        return getContentPageForLabelOrId("shop");
    }
}
