package com.mackittipat.microshop.product.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mackittipat.microshop.product.entity.Category;
import com.mackittipat.microshop.product.entity.Product;
import com.mackittipat.microshop.product.service.ProductService;
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

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

  @Autowired private MockMvc mockMvc;

  @Autowired private ObjectMapper objectMapper;

  @MockBean private ProductService productService;

  @Test
  public void findAll() throws Exception {
    List<Product> productList =
        Arrays.asList(
            Product.builder()
                .id(1)
                .name("Product1")
                .price(new BigDecimal("100.00"))
                .quantity(10)
                .category(Category.builder().id(1L).build())
                .build());

    Mockito.when(productService.findAll()).thenReturn(productList);

    mockMvc
        .perform(MockMvcRequestBuilders.get("/products").contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(1)))
        .andExpect(
            MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(productList)));

    Mockito.verify(productService, Mockito.times(1)).findAll();
  }

  @Test
  public void findById() throws Exception {
    Product product =
        Product.builder()
            .id(1)
            .name("Product1")
            .price(new BigDecimal("100.00"))
            .quantity(10)
            .category(Category.builder().id(1L).build())
            .build();

    Mockito.when(productService.findById(Mockito.anyLong())).thenReturn(product);

    mockMvc
        .perform(MockMvcRequestBuilders.get("/products/1").contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(product)));

    Mockito.verify(productService, Mockito.times(1)).findById(Mockito.anyLong());
  }

  @Test
  public void create() throws Exception {
    Product product =
        Product.builder()
            .id(1)
            .name("Product1")
            .price(new BigDecimal("100.00"))
            .quantity(10)
            .category(Category.builder().id(1L).build())
            .build();

    mockMvc
        .perform(
            MockMvcRequestBuilders.post("/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(product)))
        .andExpect(MockMvcResultMatchers.status().isOk());

    Mockito.verify(productService, Mockito.times(1)).create(Mockito.any());
  }

  @Test
  public void update() throws Exception {
    Product product =
        Product.builder()
            .id(1)
            .name("Product1")
            .price(new BigDecimal("100.00"))
            .quantity(10)
            .category(Category.builder().id(1L).build())
            .build();

    mockMvc
        .perform(
            MockMvcRequestBuilders.put("/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(product)))
        .andExpect(MockMvcResultMatchers.status().isOk());

    Mockito.verify(productService, Mockito.times(1)).update(Mockito.any());
  }
}
