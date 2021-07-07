package org.dutyfarm.core.dao;

import de.hybris.platform.servicelayer.internal.dao.GenericDao;
import org.dutyfarm.core.model.FlowerProductModel;
import org.dutyfarm.core.model.FlowerVariantProductModel;

import java.util.List;

public interface FlowerDao extends GenericDao<FlowerProductModel> {

    public List<FlowerProductModel> findAllFlowers();

}
