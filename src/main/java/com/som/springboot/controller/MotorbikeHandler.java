//package com.car.springboottest.controller;
//
//import com.car.springboottest.entity.Motorbike;
//import com.car.springboottest.repository.MotorbikeRespository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/motorbike")
//public class MotorbikeHandler {
//    @Autowired
//    private MotorbikeRespository motorbikeRespository;
//
//    @GetMapping("/findAll")
//    public List<Motorbike> findAll(){
//        return motorbikeRespository.findAll();
//    }
//}
