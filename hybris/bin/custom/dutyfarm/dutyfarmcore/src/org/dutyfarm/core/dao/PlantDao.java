package org.dutyfarm.core.dao;

import de.hybris.platform.servicelayer.internal.dao.GenericDao;
import org.dutyfarm.core.model.PlantProductModel;

import java.util.List;

public interface PlantDao extends GenericDao<PlantProductModel> {

    public List<PlantProductModel> findAllPlants();

    public List<PlantProductModel> findPlantsByFarmland(String farmland);

}
