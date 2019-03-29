package com.academia.hybris.dao;

import com.academia.hybris.model.Product;

import java.util.List;

public interface ProductDao {
    List<Product> findAll();
}
