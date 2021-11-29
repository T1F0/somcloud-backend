package com.som.springboot.controller;


import com.som.springboot.entity.ConLike;
import com.som.springboot.entity.ShoppingCart;
import com.som.springboot.repository.ConLikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conlike")
public class ConLikeHandler {
    @Autowired
    private ConLikeRepository conlikeRepository;

    @GetMapping("/findAll/{page}/{size}")                                   //R
    public Page<ConLike> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        Pageable pageable= PageRequest.of(page-1,size);
        return conlikeRepository.findAll(pageable);
    }

    @GetMapping("/findAll")                                   //备用（不分页）
    public List<ConLike> findAll(){
        return conlikeRepository.findAll();
    }

    @PostMapping("/save")                         //C
    public String save(@RequestBody ConLike conlike){
        ConLike result = conlikeRepository.save(conlike);
        if(result != null){
            return "成功";
        }else{
            return "失败";
        }
    }

    @GetMapping("/findById/{id}")                                //通过id调取信息   U
    public ConLike findById(@PathVariable("id") Integer id) {
        return conlikeRepository.findById(id).get();                    //从仓库中通过id调取信息
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
    public void deleteById(@PathVariable("id") Integer id){
        conlikeRepository.deleteById(id);
    }
}
