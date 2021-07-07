package org.dutyfarm.facades;

import org.dutyfarm.facades.data.TreeVariantProductData;

import java.util.List;

public interface TreeVariantFacade {

    public List<TreeVariantProductData> getTreesForOrigin (String origin);

}
