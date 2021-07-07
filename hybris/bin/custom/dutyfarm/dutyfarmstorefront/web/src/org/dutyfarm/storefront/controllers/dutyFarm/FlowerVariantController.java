package org.dutyfarm.storefront.controllers.dutyFarm;

import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import org.apache.log4j.Logger;
import org.dutyfarm.facades.FlowerVariantFacade;
import org.dutyfarm.facades.data.FlowerVariantProductData;
import org.dutyfarm.storefront.controllers.ControllerConstants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping(value="/dutyFarm")
public class FlowerVariantController extends AbstractPageController {

    private static final Logger LOG = Logger.getLogger(FlowerVariantController.class);

    @Resource(name="flowerVariantFacade")
    private FlowerVariantFacade flowerVariantFacade;

    @RequestMapping(value = "/flowerVariants/{color}", method = RequestMethod.GET)
    public String searchAllFlowerVariants(final Model model, final HttpServletResponse response,
                                              @PathVariable("color") final String color) {
        LOG.info("Invoke method searchAllFlowerVariants in FlowerVariantController");
        final List<FlowerVariantProductData> flowerVariants = flowerVariantFacade.getFlowersForColor(color);
        if(flowerVariants == null) {
            LOG.info("List of flowerVariants is null");
        }
        model.addAttribute("flowerVariants", flowerVariants);
        return ControllerConstants.Views.Pages.DutyFarm.DutyFarmFlowerVariantPage;
    }

}
