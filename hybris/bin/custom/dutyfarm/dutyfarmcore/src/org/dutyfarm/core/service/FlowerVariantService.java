package org.dutyfarm.core.service;

import org.dutyfarm.core.model.FlowerVariantProductModel;

import java.util.List;

public interface FlowerVariantService {

    public List<FlowerVariantProductModel> getFlowersForColor(String color);
}
