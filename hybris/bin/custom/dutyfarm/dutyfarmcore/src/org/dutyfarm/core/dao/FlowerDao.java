package org.dutyfarm.core.dao;

import org.dutyfarm.core.model.FlowerProductModel;
import org.dutyfarm.core.model.FlowerVariantProductModel;

import java.util.List;

public interface FlowerDao {

    public List<FlowerProductModel> findAllFlowers();

    public List<FlowerVariantProductModel> findFlowersByColor(String color);

}
