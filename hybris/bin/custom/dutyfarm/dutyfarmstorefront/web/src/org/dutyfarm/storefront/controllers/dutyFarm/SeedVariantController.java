package org.dutyfarm.storefront.controllers.dutyFarm;

import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import org.apache.log4j.Logger;
import org.dutyfarm.facades.SeedVariantFacade;
import org.dutyfarm.facades.data.SeedVariantProductData;
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
public class SeedVariantController extends AbstractPageController {

    private static final Logger LOG = Logger.getLogger(SeedVariantController.class);

    @Resource(name="seedVariantFacade")
    private SeedVariantFacade seedVariantFacade;

    @RequestMapping(value = "/seedVariants/{origin}", method = RequestMethod.GET)
    public String searchAllSeedVariants(final Model model, final HttpServletResponse response,
                                        @PathVariable("origin") final String origin){
        LOG.info("Invoke method searchAllSeedVariants in SeedVariantController");

        final List<SeedVariantProductData> seedVariants = seedVariantFacade.getSeedsForOrigin(origin);
        if(seedVariants == null) {
            LOG.info("List of seedVariants is null");
        }

        model.addAttribute("seedVariants", seedVariants);
        return ControllerConstants.Views.Pages.DutyFarm.DutyFarmSeedVariantPage;
    }

}
