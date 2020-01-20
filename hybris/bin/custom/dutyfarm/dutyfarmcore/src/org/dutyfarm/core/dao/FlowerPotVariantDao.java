package org.dutyfarm.core.dao;

import de.hybris.platform.servicelayer.internal.dao.GenericDao;
import org.dutyfarm.core.jalo.FlowerPotProduct;
import org.dutyfarm.core.model.FlowerPotVariantProductModel;

import java.util.List;

public interface FlowerPotVariantDao extends GenericDao<FlowerPotVariantProductModel> {

    public List<FlowerPotVariantProductModel> findFlowerPotByMaterial(String material);

}
