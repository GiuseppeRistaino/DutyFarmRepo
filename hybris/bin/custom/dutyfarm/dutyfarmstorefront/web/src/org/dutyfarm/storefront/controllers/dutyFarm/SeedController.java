package org.dutyfarm.storefront.controllers.dutyFarm;

import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import org.apache.log4j.Logger;
import org.dutyfarm.facades.SeedFacade;
import org.dutyfarm.facades.data.SeedProductData;
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
public class SeedController extends AbstractPageController {

    private static final Logger LOG = Logger.getLogger(SeedController.class);

    @Resource(name="seedFacade")
    private SeedFacade seedFacade;

    @RequestMapping(value = "/seeds", method = RequestMethod.GET)
    public String searchAllSeed(final Model model, final HttpServletResponse response) {
        LOG.info("Invoke method searchAllSeed in SeedController");

        final List<SeedProductData> seeds = seedFacade.getAllSeeds();
        if(seeds == null){
            LOG.info("List of Seed Product is null");
        }
        else{
            LOG.info("Number of elements in list of seeds: " + seeds.size());
            LOG.info("Name of the first element: " + seeds.get(0).getName());
        }

        model.addAttribute("seeds", seeds);
        return ControllerConstants.Views.Pages.DutyFarm.DutyFarmSeedPage;
    }

}
