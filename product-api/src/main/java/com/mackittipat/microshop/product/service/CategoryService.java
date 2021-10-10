package com.mackittipat.microshop.product.service;

import com.mackittipat.microshop.product.dto.CategorySearchForm;
import com.mackittipat.microshop.product.dto.CategorySearchResult;
import com.mackittipat.microshop.product.entity.Category;

import java.util.List;

public interface CategoryService {

  List<Category> findAll();

  CategorySearchResult search(CategorySearchForm categorySearchForm);

  Category findById(long id);

  void create(Category category);

  void update(Category category);
}
