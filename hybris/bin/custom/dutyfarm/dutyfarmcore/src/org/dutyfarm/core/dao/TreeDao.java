package org.dutyfarm.core.dao;

import org.dutyfarm.core.model.TreeProductModel;
import org.dutyfarm.core.model.TreeVariantProductModel;

import java.util.List;

public interface TreeDao {

    public List<TreeProductModel> findAllTrees ();

    public List<TreeVariantProductModel> findTreesByOrigin (String origin);

    //public List<TreeVariantProductModel> findTreesByHeight (String height);

}
