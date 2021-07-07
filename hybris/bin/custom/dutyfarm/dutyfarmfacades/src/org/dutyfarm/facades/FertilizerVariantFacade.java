package org.dutyfarm.facades;

import org.dutyfarm.facades.data.FertilizerVariantProductData;

import java.util.List;

public interface FertilizerVariantFacade {

    public List<FertilizerVariantProductData> getFertilizersForState(String state);

}
