package org.dutyfarm.core.dao;

import de.hybris.platform.servicelayer.internal.dao.GenericDao;
import org.dutyfarm.core.model.FertilizerVariantProductModel;

import java.util.List;

public interface FertilizerVariantDao extends GenericDao<FertilizerVariantProductModel> {

    public List<FertilizerVariantProductModel> findFertilizersByState(String state);

}
