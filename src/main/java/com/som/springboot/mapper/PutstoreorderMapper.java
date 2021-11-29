package com.som.springboot.mapper;


import com.som.springboot.entity.PutStoreOrder;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;


@Repository
public interface PutstoreorderMapper extends Mapper<PutStoreOrder> {
    @Select("SELECT * from putstoreorder where putstoreorderid=#{putstoreorderid}")
    PutStoreOrder selectPutstoreorder(@Param("putstoreorderid") String putstoreorderid);

    @Update("delete from putstoreorder where putstoreorderid=#{putstoreorderid}")
    int deletePutstoreorderid(@Param("putstoreorderid") String putstoreorderid);
}
