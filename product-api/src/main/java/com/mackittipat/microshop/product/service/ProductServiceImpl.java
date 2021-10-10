package com.mackittipat.microshop.product.service;

import com.mackittipat.microshop.product.mapper.ProductMapper;
import com.mackittipat.microshop.product.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

  @Autowired private ProductMapper productMapper;

  @Override
  public List<Product> findAll() {
    return productMapper.findAll();
  }

  @Override
  public Product findById(long id) {
    return productMapper.findById(id);
  }

  @Override
  public void create(Product product) {
    productMapper.create(product);
  }

  @Override
  public void update(Product product) {
    productMapper.update(product);
  }
}
