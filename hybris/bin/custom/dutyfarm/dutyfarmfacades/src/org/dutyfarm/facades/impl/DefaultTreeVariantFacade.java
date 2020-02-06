package org.dutyfarm.facades.impl;

import de.hybris.platform.servicelayer.dto.converter.Converter;
import org.apache.log4j.Logger;
import org.dutyfarm.core.model.TreeVariantProductModel;
import org.dutyfarm.core.service.TreeVariantService;
import org.dutyfarm.facades.TreeVariantFacade;
import org.dutyfarm.facades.data.TreeVariantProductData;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;

public class DefaultTreeVariantFacade implements TreeVariantFacade {

    private static final Logger LOG = Logger.getLogger(DefaultTreeVariantFacade.class);

    private TreeVariantService treeVariantService;

    private Converter<TreeVariantProductModel, TreeVariantProductData> treeVariantConverter;

    @Override
    public List<TreeVariantProductData> getTreesForOrigin(String origin) {

        LOG.info("Invoke method getTreesForOrigin in DefaultTreeVariantFacade");
        return treeVariantConverter.convertAll(treeVariantService.getTreesForOrigin(origin));
    }

    @Required
    public void setTreeVariantService(TreeVariantService treeVariantService) {
        this.treeVariantService = treeVariantService;
    }

    @Required
    public void setTreeVariantConverter(Converter<TreeVariantProductModel, TreeVariantProductData> treeVariantConverter) {
        this.treeVariantConverter = treeVariantConverter;
    }
}
