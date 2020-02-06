package org.dutyfarm.facades;

import org.dutyfarm.facades.data.VegetableVariantProductData;

import java.util.List;

public interface VegetableVariantFacade {

    public List<VegetableVariantProductData> getVegetablesForFarmingDifficulty(int farmingDifficulty);
}
