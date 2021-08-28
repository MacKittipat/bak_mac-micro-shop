package com.mackittipat.microshop.product.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Category {

  private Long id;
  private String uuid = UUID.randomUUID().toString();
  private String name;
  private LocalDateTime createdDate = LocalDateTime.now();
}
