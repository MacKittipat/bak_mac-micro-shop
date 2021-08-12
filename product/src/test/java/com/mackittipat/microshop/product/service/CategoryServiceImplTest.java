package com.mackittipat.microshop.product.service;

import com.mackittipat.microshop.product.mapper.CategoryMapper;
import com.mackittipat.microshop.product.model.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class CategoryServiceImplTest {

  @InjectMocks private CategoryService categoryService = new CategoryServiceImpl();

  @Mock private CategoryMapper categoryMapper;

  @Test
  void findAll() {
    List<Category> categoryList = Arrays.asList(Category.builder().id(1).name("Category1").build());

    Mockito.when(categoryMapper.findAll()).thenReturn(categoryList);

    List<Category> categoryResultList = categoryService.findAll();

    Mockito.verify(categoryMapper, Mockito.times(1)).findAll();
    Assertions.assertEquals(categoryList.size(), categoryResultList.size());
    Assertions.assertEquals(categoryList.get(0).getName(), categoryResultList.get(0).getName());
  }

  @Test
  void findById() {
    Category category = Category.builder().id(1).name("Category1").build();

    Mockito.when(categoryMapper.findById(Mockito.anyLong())).thenReturn(category);

    Category categoryResult = categoryService.findById(1);

    Mockito.verify(categoryMapper, Mockito.times(1)).findById(Mockito.anyLong());
    Assertions.assertEquals(category.getName(), categoryResult.getName());
  }

  @Test
  void create() {
    Category category = Category.builder().id(1).name("Category1").build();
    categoryService.create(category);

    Mockito.verify(categoryMapper, Mockito.times(1)).create(Mockito.any());
  }

  @Test
  void update() {
    Category category = Category.builder().id(1).name("Category1").build();
    categoryService.update(category);

    Mockito.verify(categoryMapper, Mockito.times(1)).update(Mockito.any());
  }
}
