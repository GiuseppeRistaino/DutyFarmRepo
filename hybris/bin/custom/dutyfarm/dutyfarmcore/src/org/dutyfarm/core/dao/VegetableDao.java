package org.dutyfarm.core.dao;

import de.hybris.platform.servicelayer.internal.dao.GenericDao;
import org.dutyfarm.core.model.VegetableProductModel;
import org.dutyfarm.core.model.VegetableVariantProductModel;

import java.util.List;

public interface VegetableDao extends GenericDao<VegetableProductModel> {

    public List<VegetableProductModel> findAllVegetables();

}
