package org.dutyfarm.core.dao;

import org.dutyfarm.core.jalo.FlowerPotProduct;

import java.util.List;

public interface FlowerPotDao {

    public List<FlowerPotProduct> findAllFlowerPots();
    public List<FlowerPotProduct> findFlowerPotByMaterial(String material);

}
