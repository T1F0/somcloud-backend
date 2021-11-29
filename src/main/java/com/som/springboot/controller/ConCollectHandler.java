package com.som.springboot.controller;


import com.som.springboot.entity.ConCollect;
import com.som.springboot.entity.ShoppingCart;
import com.som.springboot.repository.ConCollectRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/concollect")
@Api(tags = "需求者信息")
public class ConCollectHandler {
    @Autowired
    private ConCollectRepository concollectRepository;

    @GetMapping("/findAll/{page}/{size}")                                   //R
    public Page<ConCollect> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        Pageable pageable= PageRequest.of(page-1,size);
        return concollectRepository.findAll(pageable);
    }
    @GetMapping("/findAll")                                   //备用（不分页）
    public List<ConCollect> findAll(){
        return concollectRepository.findAll();
    }

    @PostMapping("/save")                         //C
    public String save(@RequestBody ConCollect collect){
        ConCollect result = concollectRepository.save(collect);
        if(result != null){
            return "成功";
        }else{
            return "出错";
        }
    }

    @GetMapping("/findById/{id}")                                //通过id调取信息   U
    public ConCollect findById(@PathVariable("id") Integer resourceid) {
        return concollectRepository.findById(resourceid).get();                    //从仓库中通过id调取信息
    }

//    @GetMapping("/findByName/{brand}")
//    public List<Car> findByName( String brand) {
//        return carRepository.findByName(brand).get();                    //从仓库中通过id调取信息
//    }

//    @GetMapping("/categories/{brand}")
//    public List<Car> listByCategory(@PathVariable("brand") String brand) throws Exception {
////        if (0 != cid) {
//            return carRepository.listByCategory(brand);
//        } else {
//            return list();
//        }
//    }

    @DeleteMapping("/deleteById/{id}")              //D
    public void deleteById(@PathVariable("id") Integer resourceid){
        concollectRepository.deleteById(resourceid);
    }
}
