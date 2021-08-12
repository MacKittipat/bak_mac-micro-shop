package com.mackittipat.microshop.product.service;

import com.mackittipat.microshop.product.model.Category;

import java.util.List;

public interface CategoryService {

  List<Category> findAll();

  Category findById(long id);

  void create(Category category);

  void update(Category category);
}
