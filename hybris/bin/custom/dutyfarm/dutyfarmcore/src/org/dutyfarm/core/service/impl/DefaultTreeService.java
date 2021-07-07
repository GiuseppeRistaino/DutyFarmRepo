package org.dutyfarm.core.service.impl;

import org.apache.log4j.Logger;
import org.dutyfarm.core.dao.TreeDao;
import org.dutyfarm.core.model.TreeProductModel;
import org.dutyfarm.core.service.TreeService;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;

public class DefaultTreeService implements TreeService {

    private static final Logger LOG = Logger.getLogger(DefaultTreeService.class);
    private TreeDao treeDao;

    @Override
    public List<TreeProductModel> getAllTrees() {
        LOG.info("Invoke method getAllTrees in DefaultTreeService");
        return treeDao.findAllTrees();
    }

    @Required
    public void setTreeDao(TreeDao treeDao) {
        this.treeDao = treeDao;
    }
}
