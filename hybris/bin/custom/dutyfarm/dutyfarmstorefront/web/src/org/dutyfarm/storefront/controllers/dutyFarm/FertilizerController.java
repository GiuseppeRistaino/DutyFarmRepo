package org.dutyfarm.storefront.controllers.dutyFarm;

import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import org.apache.log4j.Logger;
import org.dutyfarm.facades.FertilizerFacade;
import org.dutyfarm.facades.data.FertilizerProductData;
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
public class FertilizerController extends AbstractPageController {

    private static final Logger LOG = Logger.getLogger(FertilizerController.class);

    @Resource(name="fertilizerFacade")
    private FertilizerFacade fertilizerFacade;

    @RequestMapping(value = "/fertilizers", method = RequestMethod.GET)
    public String searchAllFertilizer(final Model model, final HttpServletResponse response) {
        LOG.info("Invoke method searchAllFertilizer in FertilizerController");
        final List<FertilizerProductData> fertilizers = fertilizerFacade.getAllFertilizers();
        if(fertilizers == null) {
            LOG.info("List of Fertilizers Product is null");
        }
        else {
            LOG.info("Number of elements in list of fertilizer: " + fertilizers.size());
            LOG.info("Name of the first element: " + fertilizers.get(0).getName());
        }
        model.addAttribute("fertilizers", fertilizers);
        return ControllerConstants.Views.Pages.DutyFarm.DutyFarmFertilizerPage;
    }




}
