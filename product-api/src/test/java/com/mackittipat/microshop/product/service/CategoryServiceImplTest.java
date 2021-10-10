package com.mackittipat.microshop.product.service;

import com.mackittipat.microshop.product.dto.CategorySearchForm;
import com.mackittipat.microshop.product.dto.CategorySearchResult;
import com.mackittipat.microshop.product.entity.Category;
import com.mackittipat.microshop.product.mapper.CategoryMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class CategoryServiceImplTest {

  @InjectMocks private CategoryService categoryService = new CategoryServiceImpl();

  @Mock private CategoryMapper categoryMapper;

  @BeforeEach
  public void setUp() {
    ReflectionTestUtils.setField(categoryService, "pageSize", 2);
  }

  @Test
  public void findAll() {
    List<Category> categoryList = Arrays.asList(Category.builder().id(1L).name("Category1").build());
    Mockito.when(categoryMapper.findAll()).thenReturn(categoryList);

    List<Category> categoryResultList = categoryService.findAll();

    Mockito.verify(categoryMapper, Mockito.times(1)).findAll();
    Assertions.assertEquals(categoryList.size(), categoryResultList.size());
    Assertions.assertEquals(categoryList.get(0).getName(), categoryResultList.get(0).getName());
  }

  @Test
  public void search() {
    CategorySearchForm categorySearchForm = new CategorySearchForm();
    categorySearchForm.setPage(1);

    List<Category> categoryList = Arrays.asList(Category.builder().id(1L).name("Category1").build());
    Mockito.when(categoryMapper.search(Mockito.any())).thenReturn(categoryList);
    Mockito.when(categoryMapper.count(Mockito.any())).thenReturn(1L);

    CategorySearchResult categorySearchResult = categoryService.search(categorySearchForm);

    Mockito.verify(categoryMapper, Mockito.times(1)).search(Mockito.any());
    Mockito.verify(categoryMapper, Mockito.times(1)).count(Mockito.any());
    Assertions.assertEquals(1, categorySearchResult.getTotalPage());
    Assertions.assertEquals(1, categorySearchResult.getTotalSize());
  }

  @Test
  public void findById() {
    Category category = Category.builder().id(1L).name("Category1").build();
    Mockito.when(categoryMapper.findById(Mockito.anyLong())).thenReturn(category);

    Category categoryResult = categoryService.findById(1);

    Mockito.verify(categoryMapper, Mockito.times(1)).findById(Mockito.anyLong());
    Assertions.assertEquals(category.getName(), categoryResult.getName());
  }

  @Test
  public void create() {
    Category category = Category.builder().id(1L).name("Category1").build();
    categoryService.create(category);

    Mockito.verify(categoryMapper, Mockito.times(1)).create(Mockito.any());
  }

  @Test
  public void update() {
    Category category = Category.builder().id(1L).name("Category1").build();
    categoryService.update(category);

    Mockito.verify(categoryMapper, Mockito.times(1)).update(Mockito.any());
  }
}
