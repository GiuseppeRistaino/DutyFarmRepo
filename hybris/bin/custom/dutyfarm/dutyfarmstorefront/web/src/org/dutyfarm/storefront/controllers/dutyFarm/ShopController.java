package org.dutyfarm.storefront.controllers.dutyFarm;

import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.catalog.CatalogVersionService;
import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.cms2.model.pages.AbstractPageModel;
import de.hybris.platform.cms2.model.pages.ContentPageModel;
import de.hybris.platform.commercefacades.product.data.CategoryData;
import org.apache.log4j.Logger;
import org.dutyfarm.facades.CategoryFacade;
import org.dutyfarm.facades.SeedFacade;
import org.dutyfarm.facades.data.DutyFarmCategoryData;
import org.dutyfarm.storefront.controllers.ControllerConstants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping(value="/dutyFarm")
public class ShopController extends AbstractPageController {

    private static final Logger LOG = Logger.getLogger(SeedController.class);

    @Resource(name="categoryFacade")
    private CategoryFacade categoryFacade;

    @Resource(name="catalogVersionService")
    private CatalogVersionService catalogVersionService;

    @RequestMapping(value = "/shop", method = RequestMethod.GET)
    public String getRootCategory(final Model model, final HttpServletResponse response)
            throws CMSItemNotFoundException {
        LOG.info("Invoke method getRootCategory in ShopController");

        List<DutyFarmCategoryData> categories = categoryFacade.findAllCategoriesForCatalogVersion(catalogVersionService.getCatalogVersion
                ("dutyFarmProductCatalog", "Staged"));
        model.addAttribute("categories", categories);

        storeCmsPageInModel(model, getCmsPage());
        setUpMetaDataForContentPage(model, (ContentPageModel) getCmsPage());
        updatePageTitle(model, getContentPageForLabelOrId(null));

        return ControllerConstants.Views.Pages.DutyFarm.DutyFarmShopPage;
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
