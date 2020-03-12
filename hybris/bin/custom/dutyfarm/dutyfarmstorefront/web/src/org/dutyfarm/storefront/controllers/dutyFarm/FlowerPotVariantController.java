package org.dutyfarm.storefront.controllers.dutyFarm;


import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import org.apache.log4j.Logger;
import org.dutyfarm.facades.FlowerPotVariantFacade;
import org.dutyfarm.facades.data.FlowerPotVariantProductData;
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
public class FlowerPotVariantController extends AbstractPageController {

    private static final Logger LOG = Logger.getLogger(FlowerPotVariantController.class);

    @Resource(name="flowerPotVariantFacade")
    private FlowerPotVariantFacade flowerPotVariantFacade;

    @RequestMapping(value = "/flowerPotVariants/{material}", method = RequestMethod.GET)
    public String searchAllFlowerPotVariants(final Model model, final HttpServletResponse response,
                                        @PathVariable("material") final String material){
        LOG.info("Invoke method searchAllFlowerPotVariants in FlowerPotVariantController");

        final List<FlowerPotVariantProductData> flowerPotVariants = flowerPotVariantFacade.getFlowerPotForMaterial(material);
        if(flowerPotVariants == null) {
            LOG.info("List of flowerPotVariants is null");
        }

        model.addAttribute("flowerPotVariants", flowerPotVariants);
        return ControllerConstants.Views.Pages.DutyFarm.DutyFarmFlowerPotVariantPage;
    }
}
