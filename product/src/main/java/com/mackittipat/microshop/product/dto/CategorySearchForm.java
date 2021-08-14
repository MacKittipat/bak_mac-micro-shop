package com.mackittipat.microshop.product.dto;

import lombok.Data;

@Data
public class CategorySearchForm {
  private int page;
  private int offset;
  private String name;
}
