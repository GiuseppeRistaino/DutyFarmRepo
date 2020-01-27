package org.dutyfarm.facades;

import org.dutyfarm.facades.data.SeedVariantProductData;

import java.util.List;

public interface SeedVariantFacade {

    public List<SeedVariantProductData> getSeedsForOrigin(String origin);

}
