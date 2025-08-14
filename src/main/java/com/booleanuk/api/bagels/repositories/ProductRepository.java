package com.booleanuk.api.bagels.repositories;

import com.booleanuk.api.bagels.models.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private List<Product> products;
    private int idCounter = 0;

    public ProductRepository() {
        products = new ArrayList<>();

        products.add(new Product(this.idCounter++, "Cheese", "Food", 10));
        products.add(new Product(this.idCounter++,  "Milk", "Food", 5));
        products.add(new Product(this.idCounter++,"Jacket", "Clothing", 100));
    }

    public List<Product> findAll() {return this.products;}

    public Product getOne(int id) {
        for (Product p : products) {
            if (p.getId() == id) {
                return p;
            }
        }

        return null;
    }

    public boolean addProduct(Product p) {
        return products.add(p);
    }

    public int size() {
        return products.size();
    }
}
