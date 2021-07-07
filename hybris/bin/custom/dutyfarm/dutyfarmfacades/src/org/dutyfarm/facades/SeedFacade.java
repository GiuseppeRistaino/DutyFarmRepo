package org.dutyfarm.facades;

import org.dutyfarm.core.model.SeedProductModel;
import org.dutyfarm.facades.data.SeedProductData;

import java.util.List;

public interface SeedFacade {

    public List<SeedProductData> getAllSeeds();

}
