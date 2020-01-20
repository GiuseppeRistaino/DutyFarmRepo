package org.dutyfarm.core.dao;

import de.hybris.platform.servicelayer.internal.dao.GenericDao;
import org.dutyfarm.core.model.SeedProductModel;

import java.util.List;

public interface SeedDao extends GenericDao<SeedProductModel> {

    public List<SeedProductModel> findAllSeeds();

}
