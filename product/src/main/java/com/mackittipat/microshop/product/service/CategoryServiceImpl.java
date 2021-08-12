package com.mackittipat.microshop.product.service;

import com.mackittipat.microshop.product.mapper.CategoryMapper;
import com.mackittipat.microshop.product.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

  @Autowired private CategoryMapper categoryMapper;

  @Override
  public List<Category> findAll() {
    return categoryMapper.findAll();
  }

  @Override
  public Category findById(long id) {
    return categoryMapper.findById(id);
  }

  @Override
  public void create(Category category) {
    categoryMapper.create(category);
  }

  @Override
  public void update(Category category) {
    categoryMapper.update(category);
  }
}
