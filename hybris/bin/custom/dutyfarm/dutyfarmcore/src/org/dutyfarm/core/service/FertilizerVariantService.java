package org.dutyfarm.core.service;

import org.dutyfarm.core.model.FertilizerVariantProductModel;

import java.util.List;

public interface FertilizerVariantService {

    public List<FertilizerVariantProductModel> getFertilizersForState(String state);

}
