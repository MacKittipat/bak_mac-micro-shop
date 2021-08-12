package com.mackittipat.microshop.product.controller;

import com.mackittipat.microshop.product.model.Product;
import com.mackittipat.microshop.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("products")
@RestController
public class ProductController {

  @Autowired private ProductService productService;

  @GetMapping
  public List<Product> findAll() {
    return productService.findAll();
  }

  @GetMapping("/{id}")
  public Product findById(@PathVariable("id") long id) {
    return productService.findById(id);
  }

  @PostMapping
  public Product create(@RequestBody Product product) {
    productService.create(product);
    return product;
  }

  @PutMapping
  public Product update(@RequestBody Product product) {
    productService.update(product);
    return product;
  }
}
