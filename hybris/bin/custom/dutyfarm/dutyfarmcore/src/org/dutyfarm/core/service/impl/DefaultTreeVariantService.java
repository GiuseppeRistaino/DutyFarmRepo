package org.dutyfarm.core.service.impl;

import org.apache.log4j.Logger;
import org.dutyfarm.core.dao.TreeVariantDao;
import org.dutyfarm.core.model.TreeVariantProductModel;
import org.dutyfarm.core.service.TreeVariantService;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;

public class DefaultTreeVariantService implements TreeVariantService {

    private static final Logger LOG = Logger.getLogger(DefaultTreeVariantService.class);
    private TreeVariantDao treeVariantDao;

    @Override
    public List<TreeVariantProductModel> getTreesForOrigin(String origin) {
        LOG.info("Invoke method getTreesForOrigin in DefaultTreeVariantService");

        return treeVariantDao.findTreesByOrigin(origin);
    }

    @Required
    public void setTreeVariantDao(TreeVariantDao treeVariantDao) {
        this.treeVariantDao = treeVariantDao;
    }
}
