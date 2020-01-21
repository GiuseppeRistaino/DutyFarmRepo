package org.dutyfarm.core.service;

import org.dutyfarm.core.model.VegetableVariantProductModel;

import java.util.List;

public interface VegetableVariantService {

    public List<VegetableVariantProductModel> getVegetablesForFarmingDifficulty(int farmingDifficulty);

}
