package org.dutyfarm.facades;


import org.dutyfarm.facades.data.FlowerPotVariantProductData;
import java.util.List;

public interface FlowerPotVariantFacade {
    public List<FlowerPotVariantProductData> getFlowerPotForMaterial(String material);
}
