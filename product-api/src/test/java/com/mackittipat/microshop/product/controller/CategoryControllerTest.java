package com.mackittipat.microshop.product.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mackittipat.microshop.product.dto.CategorySearchResult;
import com.mackittipat.microshop.product.entity.Category;
import com.mackittipat.microshop.product.service.CategoryService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

@WebMvcTest(CategoryController.class)
class CategoryControllerTest {

  @Autowired private MockMvc mockMvc;

  @Autowired private ObjectMapper objectMapper;

  @MockBean private CategoryService categoryService;

  @Test
  public void search() throws Exception {
    CategorySearchResult categorySearchResult = new CategorySearchResult();
    List<Category> categoryList = Arrays.asList(Category.builder().id(1L).name("Category1").build());
    categorySearchResult.setCategoryList(categoryList);

    Mockito.when(categoryService.search(Mockito.any())).thenReturn(categorySearchResult);

    mockMvc
        .perform(MockMvcRequestBuilders.get("/categories").contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.categories", Matchers.hasSize(1)))
        .andExpect(
            MockMvcResultMatchers.content()
                .json(objectMapper.writeValueAsString(categorySearchResult)));

    Mockito.verify(categoryService, Mockito.times(1)).search(Mockito.any());
  }

  @Test
  public void findById() throws Exception {
    Category category = Category.builder().id(1L).name("Category1").build();

    Mockito.when(categoryService.findById(Mockito.anyLong())).thenReturn(category);

    mockMvc
        .perform(
            MockMvcRequestBuilders.get("/categories/1").contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(category)));

    Mockito.verify(categoryService, Mockito.times(1)).findById(Mockito.anyLong());
  }

  @Test
  public void create() throws Exception {
    Category category = Category.builder().name("Category1").build();

    mockMvc
        .perform(
            MockMvcRequestBuilders.post("/categories")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(category)))
        .andExpect(MockMvcResultMatchers.status().isOk());

    Mockito.verify(categoryService, Mockito.times(1)).create(Mockito.any());
  }

  @Test
  public void update() throws Exception {
    Category category = Category.builder().name("Category1").build();

    mockMvc
        .perform(
            MockMvcRequestBuilders.put("/categories")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(category)))
        .andExpect(MockMvcResultMatchers.status().isOk());

    Mockito.verify(categoryService, Mockito.times(1)).update(Mockito.any());
  }
}
