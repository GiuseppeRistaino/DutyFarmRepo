package org.dutyfarm.core.service;

import org.dutyfarm.core.model.SeedVariantProductModel;

import java.util.List;

public interface SeedVariantService {

    public List<SeedVariantProductModel> getSeedsForOrigin(String origin);

}
