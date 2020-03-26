package org.dutyfarm.storefront.controllers.dutyFarm;

import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.cms2.model.pages.AbstractPageModel;
import de.hybris.platform.cms2.model.pages.ContentPageModel;
import de.hybris.platform.commercefacades.product.data.ImageData;
import de.hybris.platform.commercefacades.product.data.ProductData;
import org.apache.log4j.Logger;
import org.dutyfarm.facades.DutyFarmProductFacade;
import org.dutyfarm.facades.data.FertilizerProductData;
import org.dutyfarm.storefront.controllers.ControllerConstants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value="/dutyFarm")
public class FarmController  extends AbstractPageController {

    private static final Logger LOG = Logger.getLogger(FarmController.class);

    @Resource(name="dutyFarmProductFacade")
    private DutyFarmProductFacade dutyFarmProductFacade;

    @RequestMapping(value = "/farmProducts", method = RequestMethod.GET)
    public String searchAllFarmProducts(final Model model, final HttpServletResponse response)
            throws CMSItemNotFoundException {
        LOG.info("Invoke method searchAllFarmProducts in FarmController");
        final List<ProductData> products = dutyFarmProductFacade.getAllProducts();
        if(products == null) {
            LOG.info("List of products is null");
        }
        else {
            LOG.info("Number of elements in list of products: " + products.size());
            LOG.info("Name of the first element: " + products.get(0).getName());
        }

        model.addAttribute("products", products);

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
