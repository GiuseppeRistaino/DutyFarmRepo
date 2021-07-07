package org.dutyfarm.core.dao;

import de.hybris.platform.servicelayer.internal.dao.GenericDao;
import org.dutyfarm.core.model.VegetableVariantProductModel;

import java.util.List;

public interface VegetableVariantDao extends GenericDao<VegetableVariantProductModel> {

    public List<VegetableVariantProductModel> findVegetablesByFarmingDifficulty(int farmingDifficulty);

}
