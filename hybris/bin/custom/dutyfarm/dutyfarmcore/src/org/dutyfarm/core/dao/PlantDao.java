package org.dutyfarm.core.dao;

import org.dutyfarm.core.model.PlantProductModel;

import java.util.List;

public interface PlantDao  {

    public List<PlantProductModel> findAllPlants();

    public List<PlantProductModel> findPlantsByFarmland(String farmland);

}
