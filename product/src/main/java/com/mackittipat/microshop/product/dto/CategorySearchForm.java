package com.mackittipat.microshop.product.dto;

import lombok.Data;

@Data
public class CategorySearchForm {
  private int page = 1;
  private int offset;
  private String name;
}
