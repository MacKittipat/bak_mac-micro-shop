package com.mackittipat.microshop.product.mapper;

import com.mackittipat.microshop.product.entity.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ProductMapper {

  @Select(
      "SELECT id, uuid, name, price, quantity, created_date as createdDate FROM product ORDER BY id DESC")
  List<Product> findAll();

  @Select(
      "SELECT id, uuid, name, price, quantity, created_date as createdDate FROM product where id=#{id}")
  Product findById(long id);

  @Options(useGeneratedKeys = true, keyProperty = "id")
  @Insert(
      "INSERT INTO product (uuid, name, price, quantity, created_date, category_id) VALUES (#{uuid}, #{name}, #{price}, #{quantity}, #{createdDate}, #{category.id})")
  void create(Product product);

  @Update(
      "UPDATE product SET name=#{name}, price=#{price}, quantity=#{quantity}, category_id=#{category.id} WHERE id=#{id}")
  void update(Product product);
}
