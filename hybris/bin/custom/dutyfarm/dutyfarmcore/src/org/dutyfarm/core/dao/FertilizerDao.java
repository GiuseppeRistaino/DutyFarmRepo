package org.dutyfarm.core.dao;

import org.dutyfarm.core.model.FertilizerProductModel;
import org.dutyfarm.core.model.FertilizerVariantProductModel;

import java.util.List;

public interface FertilizerDao {

    public List<FertilizerProductModel> findAllFertilizers();
    public List<FertilizerVariantProductModel> findFertilizersByState(String state);

}
