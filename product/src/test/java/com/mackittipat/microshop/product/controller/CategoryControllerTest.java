package com.mackittipat.microshop.product.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mackittipat.microshop.product.model.Category;
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
  void findAll() throws Exception {
    List<Category> categoryList = Arrays.asList(Category.builder().id(1).name("Category1").build());

    Mockito.when(categoryService.findAll()).thenReturn(categoryList);

    mockMvc
        .perform(MockMvcRequestBuilders.get("/categories").contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(1)))
        .andExpect(
            MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(categoryList)));

    Mockito.verify(categoryService, Mockito.times(1)).findAll();
  }

  @Test
  void findById() throws Exception {
    Category category = Category.builder().id(1).name("Category1").build();

    Mockito.when(categoryService.findById(Mockito.anyLong())).thenReturn(category);

    mockMvc
        .perform(
            MockMvcRequestBuilders.get("/categories/1").contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(category)));

    Mockito.verify(categoryService, Mockito.times(1)).findById(Mockito.anyLong());
  }

  @Test
  void create() throws Exception {
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
  void update() throws Exception {
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
