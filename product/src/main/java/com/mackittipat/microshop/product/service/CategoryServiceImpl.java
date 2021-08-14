package com.mackittipat.microshop.product.service;

import com.mackittipat.microshop.product.dto.CategorySearchForm;
import com.mackittipat.microshop.product.dto.CategorySearchResult;
import com.mackittipat.microshop.product.entity.Category;
import com.mackittipat.microshop.product.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

  @Autowired private CategoryMapper categoryMapper;

  @Value("${app.pagination.page.size}")
  private int pageSize;

  @Override
  public List<Category> findAll() {
    return categoryMapper.findAll();
  }

  @Override
  public CategorySearchResult search(CategorySearchForm categorySearchForm) {
    CategorySearchResult categorySearchResult = new CategorySearchResult();
    categorySearchResult.setCategoryList(categoryMapper.search(categorySearchForm));
    categorySearchResult.setTotalSize(categoryMapper.count(categorySearchForm));
    categorySearchResult.setTotalPage((categorySearchResult.getTotalSize() / pageSize) + 1);
    return categorySearchResult;
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
