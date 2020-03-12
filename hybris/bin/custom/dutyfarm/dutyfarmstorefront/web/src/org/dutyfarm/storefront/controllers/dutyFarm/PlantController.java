package org.dutyfarm.storefront.controllers.dutyFarm;

import org.springframework.ui.Model;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import org.apache.log4j.Logger;
import org.dutyfarm.facades.PlantFacade;
import org.dutyfarm.facades.data.PlantProductData;
import org.dutyfarm.storefront.controllers.ControllerConstants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping(value="/dutyFarm")
public class PlantController extends AbstractPageController {

    private static final Logger LOG = Logger.getLogger(PlantController.class);

    @Resource(name="plantFacade")
    private PlantFacade plantFacade;

    @RequestMapping(value = "/plants", method = RequestMethod.GET)
    public String searchAllPlant(final Model model, final HttpServletResponse response) {
        LOG.info("Invoke method searchAllPlant in PlantController");

        final List<PlantProductData> plants = plantFacade.getAllPlants();
        if(plants == null){
            LOG.info("List of Plant Product is null");
        }
        else{
            LOG.info("Number of elements in list of plants: " + plants.size());
            LOG.info("Name of the first element: " + plants.get(0).getName());
        }

        model.addAttribute("plants", plants);
        return ControllerConstants.Views.Pages.DutyFarm.DutyFarmPlantPage;
    }
}
