package org.dutyfarm.core.dao;

import de.hybris.platform.servicelayer.internal.dao.GenericDao;
import org.dutyfarm.core.model.SeedVariantProductModel;

import java.util.List;

public interface SeedVariantDao extends GenericDao<SeedVariantProductModel> {

    public List<SeedVariantProductModel> findSeedsByOrigin(String origin);

}
