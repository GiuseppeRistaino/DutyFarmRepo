package org.dutyfarm.core.dao;

import de.hybris.platform.servicelayer.internal.dao.GenericDao;
import org.dutyfarm.core.jalo.FlowerPotProduct;
import org.dutyfarm.core.model.FlowerPotProductModel;

import java.util.List;

public interface FlowerPotDao extends GenericDao<FlowerPotProductModel> {

    public List<FlowerPotProductModel> findAllFlowerPots();

}
