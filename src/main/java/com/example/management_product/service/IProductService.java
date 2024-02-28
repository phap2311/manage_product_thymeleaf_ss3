package com.example.management_product.service;

import com.example.management_product.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    void save(Product product);

    Product findById(int id);

    void update(int id, Product product);

    void delete(int id);


    List<Product> findByName(String searchName);
}
