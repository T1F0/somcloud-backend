package com.som.springboot.mapper;

import com.som.springboot.entity.Demand;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DemandMapper {
    @Select("select * from demand where id = #{id}")
    Demand findById(Integer id);

    @Select("select * from demand")
    List<Demand> findAll();
}
