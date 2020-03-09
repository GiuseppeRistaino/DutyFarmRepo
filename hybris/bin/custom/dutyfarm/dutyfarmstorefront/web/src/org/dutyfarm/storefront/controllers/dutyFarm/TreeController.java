package org.dutyfarm.storefront.controllers.dutyFarm;


import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import org.apache.log4j.Logger;
import org.dutyfarm.facades.TreeFacade;
import org.dutyfarm.facades.data.TreeProductData;
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
public class TreeController extends AbstractPageController {

    private static final Logger LOG = Logger.getLogger(TreeController.class);

    @Resource(name="treeFacade")
    private TreeFacade treeFacade;

    @RequestMapping(value = "/trees", method = RequestMethod.GET)
    public String searchAllTree(final Model model, final HttpServletResponse response) {
        LOG.info("Invoke method searchAllTree in TreeController");

        final List<TreeProductData> trees =  treeFacade.getAllTrees();
        if(trees == null){
            LOG.info("List of Tree Product is null");
        }
        else{
            LOG.info("Number of elements in list of trees: " + trees.size());
            LOG.info("Name of the first element: " + trees.get(0).getName());
        }

        model.addAttribute("trees", trees);
        return ControllerConstants.Views.Pages.DutyFarm.DutyFarmTreePage;
    }

}
