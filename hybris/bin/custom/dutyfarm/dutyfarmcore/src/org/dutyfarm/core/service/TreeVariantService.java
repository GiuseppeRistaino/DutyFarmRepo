package org.dutyfarm.core.service;

import org.dutyfarm.core.model.TreeVariantProductModel;

import java.util.List;

public interface TreeVariantService {

    public List<TreeVariantProductModel> getTreesForOrigin (String origin);
}
