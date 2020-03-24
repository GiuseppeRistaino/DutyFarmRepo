package org.dutyfarm.core.service.impl;

import de.hybris.platform.core.model.product.ProductModel;
import org.apache.log4j.Logger;
import org.dutyfarm.core.dao.DutyFarmProductDao;
import org.dutyfarm.core.service.DutyFarmProductService;

import javax.annotation.Resource;
import java.util.List;

public class DefaultDutyFarmProductService implements DutyFarmProductService {

    private static final Logger LOG = Logger.getLogger(DefaultDutyFarmProductService.class);

    @Resource (name = "dutyFarmProductDao")
    private DutyFarmProductDao dutyFarmProductDao;

    @Override
    public List<ProductModel> getAllProducts() {
        LOG.info("Invoke method getAllProducts in DefaultDutyFarmProductService");
        return dutyFarmProductDao.findAllProducts();
    }

    @Override
    public List<ProductModel> getAllProductsForCategory(String category) {
        LOG.info("Invoke method getAllProductsForCategory in DefaultDutyFarmProductService");
        return dutyFarmProductDao.findAllProductsForCategory(category);
    }

    @Override
    public List<ProductModel> getAllProductsForName(String name) {
        LOG.info("Invoke method getAllProductsForName in DefaultDutyFarmProductService");
        return dutyFarmProductDao.findAllProductsForName(name);
    }
}
