package com.academia.hybris.service.impl;

import com.academia.hybris.dao.ProductDao;
import com.academia.hybris.model.Product;
import com.academia.hybris.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DefaultProductService implements ProductService {

    @Autowired
    private ProductDao productDao;

    public List<Product> findAll() {
        return productDao.findAll();
    }
}
