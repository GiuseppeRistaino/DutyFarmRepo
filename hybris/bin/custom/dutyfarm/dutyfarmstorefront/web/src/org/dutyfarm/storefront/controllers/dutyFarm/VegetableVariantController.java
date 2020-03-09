package org.dutyfarm.storefront.controllers.dutyFarm;


import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import org.apache.log4j.Logger;
import org.dutyfarm.facades.VegetableVariantFacade;
import org.dutyfarm.facades.data.VegetableVariantProductData;
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
public class VegetableVariantController extends AbstractPageController {

    private static final Logger LOG = Logger.getLogger(VegetableVariantController.class);

    @Resource(name="vegetableVariantFacade")
    private VegetableVariantFacade vegetableVariantFacade;

    @RequestMapping(value = "/vegetableVariants/{farmingDifficulty}", method = RequestMethod.GET)
    public String searchAllVegetableVariants(final Model model, final HttpServletResponse response,
                                        @PathVariable("farmingDifficulty") final int farmingDifficulty){
        LOG.info("Invoke method searchAllVegetableVariants in VegetableVariantController");

        final List<VegetableVariantProductData> vegetableVariants = vegetableVariantFacade.getVegetablesForFarmingDifficulty(farmingDifficulty);
        if(vegetableVariants == null) {
            LOG.info("List of vegetableVariants is null");
        }

        model.addAttribute("vegetableVariants", vegetableVariants);
        return ControllerConstants.Views.Pages.DutyFarm.DutyFarmVegetableVariantPage;
    }

}
