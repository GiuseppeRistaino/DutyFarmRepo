package org.dutyfarm.core.dao;

import de.hybris.platform.servicelayer.internal.dao.GenericDao;
import org.dutyfarm.core.model.TreeProductModel;
import org.dutyfarm.core.model.TreeVariantProductModel;

import java.util.List;

public interface TreeDao extends GenericDao<TreeProductModel> {

    public List<TreeProductModel> findAllTrees ();

}
