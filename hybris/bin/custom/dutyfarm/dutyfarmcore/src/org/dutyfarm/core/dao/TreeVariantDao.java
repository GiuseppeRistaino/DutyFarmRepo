package org.dutyfarm.core.dao;

import de.hybris.platform.servicelayer.internal.dao.GenericDao;
import org.dutyfarm.core.model.TreeVariantProductModel;

import java.util.List;

public interface TreeVariantDao extends GenericDao<TreeVariantProductModel> {

    public List<TreeVariantProductModel> findTreesByOrigin (String origin);

    //public List<TreeVariantProductModel> findTreesByHeight (String height);

}
