package org.dutyfarm.storefront.controllers.dutyFarm;

import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import org.apache.log4j.Logger;
import org.dutyfarm.facades.FlowerFacade;
import org.dutyfarm.facades.data.FlowerProductData;
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
public class FlowerController extends AbstractPageController {

    private static final Logger LOG = Logger.getLogger(FlowerController.class);

    @Resource(name="flowerFacade")
    private FlowerFacade flowerFacade;

    @RequestMapping(value = "/flowers", method = RequestMethod.GET)
    public String searchAllFlower(final Model model, final HttpServletResponse response) {
        LOG.info("Invoke method searchAllFlower in FlowerController");

        final List<FlowerProductData> flowers = flowerFacade.getAllFlowers();
        if(flowers == null){
            LOG.info("List of Flower Product is null");
        }
        else{
            LOG.info("Number of elements in list of flowers: " + flowers.size());
            LOG.info("Name of the first element: " + flowers.get(0).getName());
        }

        model.addAttribute("flowers", flowers);
        return ControllerConstants.Views.Pages.DutyFarm.DutyFarmFlowerPage;
    }

}
