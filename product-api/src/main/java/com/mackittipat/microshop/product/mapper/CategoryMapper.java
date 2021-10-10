package com.mackittipat.microshop.product.mapper;

import com.mackittipat.microshop.product.dto.CategorySearchForm;
import com.mackittipat.microshop.product.entity.Category;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface CategoryMapper {

  @Select("SELECT id, uuid, name, created_date as createdDate FROM category ORDER BY id DESC")
  List<Category> findAll();

  List<Category> search(CategorySearchForm categorySearchForm);

  long count(CategorySearchForm categorySearchForm);

  @Select("SELECT id, uuid, name, created_date as createdDate FROM category WHERE id=#{id}")
  Category findById(long id);

  @Options(useGeneratedKeys = true, keyProperty = "id")
  @Insert(
      "INSERT INTO category (uuid, name, created_date) VALUES (#{uuid}, #{name}, #{createdDate})")
  void create(Category category);

  @Update("UPDATE category SET name=#{name} WHERE id=#{id}")
  void update(Category category);
}
