package com.booleanuk.api.bagels.controller;

import com.booleanuk.api.bagels.models.Product;
import com.booleanuk.api.bagels.repositories.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {
    private ProductRepository productRepository;

    public ProductController() {
        productRepository = new ProductRepository();
    }

    @GetMapping
    public List<Product> getAll() {
        return this.productRepository.findAll();
    }

    @GetMapping("{id}")
    public Product getOne(@PathVariable int id) {
        return this.productRepository.getOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product create(@RequestBody Product product) {
        this.productRepository.addProduct(product);
        return product;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Product update(@PathVariable(name = "id") int id, @RequestBody Product product) {
        if (id < this.productRepository.size()) {
            this.productRepository.findAll().get(id).setId(id);
            this.productRepository.findAll().get(id).setName(product.getName());
            this.productRepository.findAll().get(id).setCategory(product.getCategory());
            this.productRepository.findAll().get(id).setPrice(product.getPrice());
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public Product delete(@PathVariable (name = "id") int id) {
        if (id < this.productRepository.size()) {
            return this.productRepository.findAll().remove(id);
        }
        return null;
    }
}
