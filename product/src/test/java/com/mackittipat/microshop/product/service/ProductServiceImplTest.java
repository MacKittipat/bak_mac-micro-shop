package com.mackittipat.microshop.product.service;

import com.mackittipat.microshop.product.mapper.ProductMapper;
import com.mackittipat.microshop.product.entity.Category;
import com.mackittipat.microshop.product.entity.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

  @InjectMocks private ProductService productService = new ProductServiceImpl();

  @Mock private ProductMapper productMapper;

  @Test
  public void findAll() {
    List<Product> productList =
        Arrays.asList(
            Product.builder()
                .id(1)
                .name("Product1")
                .price(new BigDecimal("100.00"))
                .quantity(10)
                .category(Category.builder().id(1).build())
                .build());

    Mockito.when(productMapper.findAll()).thenReturn(productList);

    List<Product> productResultList = productService.findAll();

    Mockito.verify(productMapper, Mockito.times(1)).findAll();
    Assertions.assertEquals(productList.size(), productResultList.size());
    Assertions.assertEquals(productList.get(0).getName(), productResultList.get(0).getName());
  }

  @Test
  public void findById() {
    Product product =
        Product.builder()
            .id(1)
            .name("Product1")
            .price(new BigDecimal("100.00"))
            .quantity(10)
            .category(Category.builder().id(1).build())
            .build();

    Mockito.when(productMapper.findById(Mockito.anyLong())).thenReturn(product);

    Product productResult = productService.findById(1);

    Mockito.verify(productMapper, Mockito.times(1)).findById(Mockito.anyLong());
    Assertions.assertEquals(product.getName(), productResult.getName());
  }

  @Test
  public void create() {
    Product product =
        Product.builder()
            .id(1)
            .name("Product1")
            .price(new BigDecimal("100.00"))
            .quantity(10)
            .category(Category.builder().id(1).build())
            .build();

    productService.create(product);
    Mockito.verify(productMapper, Mockito.times(1)).create(Mockito.any());
  }

  @Test
  public void update() {
    Product product =
        Product.builder()
            .id(1)
            .name("Product1")
            .price(new BigDecimal("100.00"))
            .quantity(10)
            .category(Category.builder().id(1).build())
            .build();

    productService.update(product);
    Mockito.verify(productMapper, Mockito.times(1)).update(Mockito.any());
  }
}
