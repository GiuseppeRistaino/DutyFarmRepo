package org.dutyfarm.core.dao;

import org.dutyfarm.core.model.VegetableProductModel;
import org.dutyfarm.core.model.VegetableVariantProductModel;

import java.util.List;

public interface VegetableDao {

    public List<VegetableProductModel> findAllVegetables();

    public List<VegetableVariantProductModel> findVegetablesByFarmingDifficulty(int farmingDifficulty);

}
