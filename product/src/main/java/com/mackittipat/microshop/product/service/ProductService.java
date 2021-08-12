package com.mackittipat.microshop.product.service;

import com.mackittipat.microshop.product.model.Product;

import java.util.List;

public interface ProductService {

  List<Product> findAll();

  Product findById(long id);

  void create(Product product);

  void update(Product product);
}
