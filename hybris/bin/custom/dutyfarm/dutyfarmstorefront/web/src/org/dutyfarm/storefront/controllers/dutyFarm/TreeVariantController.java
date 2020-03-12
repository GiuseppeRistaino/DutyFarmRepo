package org.dutyfarm.storefront.controllers.dutyFarm;


import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import org.apache.log4j.Logger;
import org.dutyfarm.facades.TreeVariantFacade;
import org.dutyfarm.facades.data.TreeVariantProductData;
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
public class TreeVariantController extends AbstractPageController {

    private static final Logger LOG = Logger.getLogger(TreeVariantController.class);

    @Resource(name="treeVariantFacade")
    private TreeVariantFacade treeVariantFacade;

    @RequestMapping(value = "/treeVariants/{origin}", method = RequestMethod.GET)
    public String searchAllTreeVariants(final Model model, final HttpServletResponse response,
                                        @PathVariable("origin") final String origin){
        LOG.info("Invoke method searchAllTreeVariants in TreeVariantController");

        final List<TreeVariantProductData> treeVariants = treeVariantFacade.getTreesForOrigin(origin);
        if(treeVariants == null) {
            LOG.info("List of treeVariants is null");
        }

        model.addAttribute("treeVariants", treeVariants);
        return ControllerConstants.Views.Pages.DutyFarm.DutyFarmTreeVariantPage;
    }

}
