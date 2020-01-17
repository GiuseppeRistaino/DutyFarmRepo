package org.dutyfarm.core.dao;

import org.dutyfarm.core.model.SeedProductModel;
import org.dutyfarm.core.model.SeedVariantProductModel;

import java.util.List;

public interface SeedDao {

    public List<SeedProductModel> findAllSeeds();
    public List<SeedVariantProductModel> findSeedsByOrigin(String origin);

}
