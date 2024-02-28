package com.example.management_product.service;

import com.example.management_product.model.Product;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements IProductService {

    private static List<Product> products = new ArrayList<>();


    static {

        products.add(new Product(1, "tivi", 10000, "sieu mong", "panasonic"));
        products.add(new Product(2, "tu lanh", 20000, "sieu ben", "sam sum"));
        products.add(new Product(3, "dien thoai", 30000, "sieu nhe", "apple"));
        products.add(new Product(4, "may tinh", 35000, "quay 360", "dell"));
        products.add(new Product(5, "lo vi song", 15000, "sieu nhanh", "panasonic"));

    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void save(Product product) {
        products.add(product);
    }

    @Override
    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }

        return null;
    }

    @Override
    public void update(int id, Product product) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                products.set(i, product);
                break;
            }
        }
    }

    @Override
    public void delete(int id) {
        products.remove(id);
    }

    @Override
    public List<Product> findByName(String searchName) {
        List<Product> products1 = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().contains(searchName)) {
                products1.add(product);
            }
        }


        return products1;
    }
}
