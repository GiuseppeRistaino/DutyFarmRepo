package org.dutyfarm.facades;

import org.dutyfarm.facades.data.FlowerVariantProductData;

import java.util.List;

public interface FlowerVariantFacade {

    public List<FlowerVariantProductData> getFlowersForColor(String color);


}
