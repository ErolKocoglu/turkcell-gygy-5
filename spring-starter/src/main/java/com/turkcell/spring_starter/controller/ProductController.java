package com.turkcell.spring_starter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.spring_starter.model.Product;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @GetMapping("")
    public String getAllProducts() {
        return "All products";
    }

    @GetMapping("/{name}/{age}")
    public String getProductByNameAndAge(@PathVariable String name, @PathVariable int age) {
        return "Product: " + name + ", Age: " + age;
    }

    @PostMapping
    public Product add(@RequestBody Product product){ // Json->Java objesine
        // isim 1 haneden uzun mu?
        // fiyat..
        // DB'e kaydet..

        return product;
    }
}
