package com.mackittipat.microshop.product.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mackittipat.microshop.product.entity.Category;
import lombok.Data;

import java.util.List;

@Data
public class CategorySearchResult {

  @JsonProperty("categories")
  private List<Category> categoryList;

  private long totalSize;
  private long totalPage;
}
