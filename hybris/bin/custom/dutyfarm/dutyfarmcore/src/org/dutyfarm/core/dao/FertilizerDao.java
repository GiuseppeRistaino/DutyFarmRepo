package org.dutyfarm.core.dao;

import de.hybris.platform.servicelayer.internal.dao.GenericDao;
import org.dutyfarm.core.model.FertilizerProductModel;

import java.util.List;

public interface FertilizerDao extends GenericDao<FertilizerProductModel> {

    public List<FertilizerProductModel> findAllFertilizers();

}
