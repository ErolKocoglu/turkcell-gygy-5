package com.turkcell.spring_starter.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.spring_starter.model.Product;

@RestController 
@RequestMapping("/api/product") 
public class ProductController {
    // In-Memory Çalış..
    private List<Product> productList = new ArrayList<>();


    @GetMapping()
    public List<Product> getAllProducts() {
        return productList;
    }

    @GetMapping("{id}")
    public Product getProductById(@PathVariable int id) 
    {
        // Listeden id == product.getId() ise onu yoksa null dön.
        return productList.stream().filter(i->i.getId() == id).findFirst().orElse(null);
    }

    @PostMapping
    public void createProduct(@RequestBody Product product) {
        productList.add(product);
    }
    @PutMapping
    public void updateProduct(@RequestBody Product product) {
        ///..
        Product productToUpdate = productList.stream().filter(p -> p.getId() == product.getId()).findFirst().orElseThrow();

        productToUpdate.setName(product.getName());
        productToUpdate.setPrice(product.getPrice());
    }
    @DeleteMapping("{id}")
    public void deleteProduct(@PathVariable int id) {
        ///.. Todo..
    }
}
