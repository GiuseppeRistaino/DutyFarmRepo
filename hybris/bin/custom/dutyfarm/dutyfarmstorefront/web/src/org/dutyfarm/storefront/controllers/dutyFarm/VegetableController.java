package org.dutyfarm.storefront.controllers.dutyFarm;

import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import org.apache.log4j.Logger;
import org.dutyfarm.facades.VegetableFacade;
import org.dutyfarm.facades.data.VegetableProductData;
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
public class VegetableController extends AbstractPageController {

    private static final Logger LOG = Logger.getLogger(VegetableController.class);

    @Resource(name="vegetableFacade")
    private VegetableFacade vegetableFacade;

    @RequestMapping(value = "/vegetables", method = RequestMethod.GET)
    public String searchAllVegetable(final Model model, final HttpServletResponse response) {
        LOG.info("Invoke method searchAllVegetable in VegetableController");

        final List<VegetableProductData> vegetables = vegetableFacade.getAllVegetables();
        if(vegetables == null){
            LOG.info("List of Vegetable Product is null");
        }
        else{
            LOG.info("Number of elements in list of vegetables: " + vegetables.size());
            LOG.info("Name of the first element: " + vegetables.get(0).getName());
        }

        model.addAttribute("vegetables", vegetables);
        return ControllerConstants.Views.Pages.DutyFarm.DutyFarmVegetablePage;
    }

}
