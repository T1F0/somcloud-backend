package com.som.springboot.mapper;

import com.som.springboot.entity.Resource;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;


@Repository
public interface ResourceMapper extends Mapper<Resource> {

    @Select("select resourceid,resourceform from resource where createuserid =#{createuserid};")
    List<Resource> selectResource(@Param("createuserid") String record);
}
