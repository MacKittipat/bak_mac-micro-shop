package com.mackittipat.microshop.product.controller;

import com.mackittipat.microshop.product.model.Category;
import com.mackittipat.microshop.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("categories")
@RestController
public class CategoryController {

  @Autowired private CategoryService categoryService;

  @GetMapping
  public List<Category> findAll() {
    return categoryService.findAll();
  }

  @GetMapping("/{id}")
  public Category findById(@PathVariable("id") long id) {
    return categoryService.findById(id);
  }

  @PostMapping
  public Category create(@RequestBody Category category) {
    categoryService.create(category);
    return category;
  }

  @PutMapping
  public Category update(@RequestBody Category category) {
    categoryService.update(category);
    return category;
  }
}
