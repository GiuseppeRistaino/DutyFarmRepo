package org.dutyfarm.facades.impl;

import de.hybris.platform.servicelayer.dto.converter.Converter;
import org.apache.log4j.Logger;
import org.dutyfarm.core.model.TreeProductModel;
import org.dutyfarm.core.service.TreeService;
import org.dutyfarm.facades.TreeFacade;
import org.dutyfarm.facades.data.TreeProductData;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;

public class DefaultTreeFacade implements TreeFacade {

    private static final Logger LOG = Logger.getLogger(DefaultTreeFacade.class);

    private TreeService treeService;

    private Converter<TreeProductModel, TreeProductData> treeConverter;

    @Override
    public List<TreeProductData> getAllTrees() {

        LOG.info("Invoke method getAllTrees in DefaultTreeFacade");
        return treeConverter.convertAll(treeService.getAllTrees());
    }

    @Required
    public void setTreeService(TreeService treeService) {
        this.treeService = treeService;
    }

    @Required
    public void setTreeConverter(Converter<TreeProductModel, TreeProductData> treeConverter) {
        this.treeConverter = treeConverter;
    }
}
