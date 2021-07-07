package org.dutyfarm.core.dao;

import de.hybris.platform.servicelayer.internal.dao.GenericDao;
import org.dutyfarm.core.model.FlowerVariantProductModel;

import java.util.List;

public interface FlowerVariantDao extends GenericDao<FlowerVariantProductModel> {

    public List<FlowerVariantProductModel> findFlowersByColor(String color);

}
