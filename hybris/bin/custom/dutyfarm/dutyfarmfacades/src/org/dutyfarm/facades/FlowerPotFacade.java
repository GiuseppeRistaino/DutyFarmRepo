package org.dutyfarm.facades;

import org.dutyfarm.core.model.FlowerPotProductModel;
import org.dutyfarm.facades.data.FlowerPotProductData;

import java.util.List;

public interface FlowerPotFacade {

    public List<FlowerPotProductData> getAllFlowerPots();

}
