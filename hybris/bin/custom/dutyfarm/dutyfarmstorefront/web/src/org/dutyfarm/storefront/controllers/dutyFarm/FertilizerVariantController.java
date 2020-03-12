package org.dutyfarm.storefront.controllers.dutyFarm;

import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import org.apache.log4j.Logger;
import org.dutyfarm.facades.FertilizerVariantFacade;
import org.dutyfarm.facades.data.FertilizerVariantProductData;
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
public class FertilizerVariantController extends AbstractPageController {

    private static final Logger LOG = Logger.getLogger(FertilizerVariantController.class);

    @Resource(name="fertilizerVariantFacade")
    private FertilizerVariantFacade fertilizerVariantFacade;

    @RequestMapping(value = "/fertilizerVariants/{state}", method = RequestMethod.GET)
    public String searchAllFertilizerVariants(final Model model, final HttpServletResponse response,
                                              @PathVariable("state") final String state) {
        LOG.info("Invoke method searchAllFertilizerVariants in FertilizerVariantController");
        final List<FertilizerVariantProductData> fertilizerVariants = fertilizerVariantFacade.getFertilizersForState(state);
        if(fertilizerVariants == null) {
            LOG.info("List of fertilizerVariants is null");
        }
        model.addAttribute("fertilizerVariants", fertilizerVariants);
        return ControllerConstants.Views.Pages.DutyFarm.DutyFarmFertilizerVariantPage;
    }

}
