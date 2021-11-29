package com.som.springboot.mapper;

import com.som.springboot.entity.WorkOrder;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkOrderMapper {

    @Select("select * from workOrder")
    List<WorkOrder> findAll();

    @Select("select * from workOrder where id = #{id}")
    WorkOrder findById(@Param("id")Integer id);
}
