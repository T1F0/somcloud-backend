package com.som.springboot.controller;

import com.som.springboot.entity.Resource;
import com.som.springboot.mapper.ResourceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/resource1")
public class ResourceHandlerv {
    @Autowired
    private ResourceMapper resourceMapper;

    @GetMapping("allByName")
    public List<Resource> all(String createuserid) {
        Resource record=new Resource();
        record.setCreateuserid(createuserid);
        return resourceMapper.select(record);
    }
}

