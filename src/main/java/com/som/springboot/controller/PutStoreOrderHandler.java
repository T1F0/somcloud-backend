package com.som.springboot.controller;


import com.som.springboot.entity.PutStoreOrder;
import com.som.springboot.entity.Resource;
import com.som.springboot.mapper.PutstoreorderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/putstore")
public class PutStoreOrderHandler {
    @Autowired
    private PutstoreorderMapper putstoreorderMapper;

    @GetMapping("allByName")
    public List<PutStoreOrder> all(Integer putstoreorderid) {
        PutStoreOrder record=new PutStoreOrder();
        record.setPutstoreorderid(putstoreorderid);
        return putstoreorderMapper.select(record);
    }

    @GetMapping("deleteById")
    public String deletePutstoreorder(String putstoreorderid){
        int result = putstoreorderMapper.deletePutstoreorderid(putstoreorderid);
        if (result==1){
            return "删除成功";
        } else {
            return "删除失败";
        }
    }
}
