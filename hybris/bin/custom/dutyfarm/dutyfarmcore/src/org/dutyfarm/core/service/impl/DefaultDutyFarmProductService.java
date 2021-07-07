package org.dutyfarm.core.service.impl;

import de.hybris.platform.category.model.CategoryModel;
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
    public List<ProductModel> getAllProducts(int start, int count) {
        LOG.info("Invoke method getAllProducts in DefaultDutyFarmProductService");
        return dutyFarmProductDao.findAllProducts(start, count);
    }

    @Override
    public Integer countAllProducts() {
        LOG.info("Invoke method countAllProducts in DefaultDutyFarmProductService");
        return dutyFarmProductDao.countAllProducts();
    }

    @Override
    public List<ProductModel> getAllProductsForCategory(CategoryModel category, int start, int count) {
        LOG.info("Invoke method getAllProductsForCategory in DefaultDutyFarmProductService");
        return dutyFarmProductDao.findAllProductsForCategory(category, start, count);
    }

    @Override
    public Integer countAllProductsForCategory(CategoryModel category) {
        LOG.info("Invoke method countAllProductsForCategory in DefaultDutyFarmProductService");
        return dutyFarmProductDao.countAllProductsForCategory(category);
    }

    @Override
    public List<ProductModel> getAllProductsForName(String name, int start, int count) {
        LOG.info("Invoke method getAllProductsForName in DefaultDutyFarmProductService");
        return dutyFarmProductDao.findAllProductsForName(name, start, count);
    }

    @Override
    public Integer countAllProductsForName(String name) {
        LOG.info("Invoke method countAllProductsForName in DefaultDutyFarmProductService");
        return dutyFarmProductDao.countAllProductsForName(name);
    }
}
