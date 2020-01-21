package org.dutyfarm.core.service;

import org.dutyfarm.core.model.FlowerPotVariantProductModel;

import java.util.List;

public interface FlowerPotVariantService {

    public List<FlowerPotVariantProductModel> getFlowerPotForMaterial(String material);

}
