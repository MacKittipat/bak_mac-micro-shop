package com.mackittipat.microshop.product.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {

  private long id;
  private String uuid = UUID.randomUUID().toString();
  private String name;
  private BigDecimal price;
  private long quantity;
  private LocalDateTime createdDate = LocalDateTime.now();
  private Category category;
}
