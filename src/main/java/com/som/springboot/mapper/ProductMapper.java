package com.som.springboot.mapper;


import com.som.springboot.entity.Product;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductMapper {

    @Select("select * from product where id = #{id}")
    Product findById(Integer id);

    @Select("select * from product")
    List<Product> findAll();
}
