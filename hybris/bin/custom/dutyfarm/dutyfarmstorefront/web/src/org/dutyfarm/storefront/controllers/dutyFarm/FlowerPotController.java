package org.dutyfarm.storefront.controllers.dutyFarm;

import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import org.apache.log4j.Logger;
import org.dutyfarm.facades.FlowerPotFacade;
import org.dutyfarm.facades.data.FlowerPotProductData;
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
public class FlowerPotController extends AbstractPageController {

    private static final Logger LOG = Logger.getLogger(FlowerPotController.class);

    @Resource(name="flowerPotFacade")
    private FlowerPotFacade flowerPotFacade;

    @RequestMapping(value = "/flowerPots", method = RequestMethod.GET)
    public String searchAllFlowerPot(final Model model, final HttpServletResponse response) {
        LOG.info("Invoke method searchAllFlowerPot in FlowerPotController");

        final List<FlowerPotProductData> flowerPots = flowerPotFacade.getAllFlowerPots();
        if(flowerPots == null){
            LOG.info("List of FlowerPot Product is null");
        }
        else{
            LOG.info("Number of elements in list of flowerPots: " + flowerPots.size());
            LOG.info("Name of the first element: " + flowerPots.get(0).getName());
        }

        model.addAttribute("flowerPots", flowerPots);
        return ControllerConstants.Views.Pages.DutyFarm.DutyFarmFlowerPotPage;
    }

}
