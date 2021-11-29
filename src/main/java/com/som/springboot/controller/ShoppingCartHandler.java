package com.som.springboot.controller;

import com.som.springboot.entity.Resource;
import com.som.springboot.entity.ShoppingCart;
import com.som.springboot.repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shoppingcart")                //从数据库里找同名的表名
public class ShoppingCartHandler {
    @Autowired
    private ShoppingCartRepository shoppingcartRepository;

    @GetMapping("/findAll")                                   //备用（不分页）
    public List<ShoppingCart> findAll(){
        return shoppingcartRepository.findAll();
    }

    @PostMapping("/save")                         //C
    public String save(@RequestBody ShoppingCart shoppingcart){
        ShoppingCart result = shoppingcartRepository.save(shoppingcart);
        if(result != null){
            return "成功";
        }else{
            return "出错";
        }
    }

    @GetMapping("/findById/{id}")                                //通过id调取信息   U
    public ShoppingCart findById(@PathVariable("id") Integer resourceid) {
        return shoppingcartRepository.findById(resourceid).get();                    //从仓库中通过id调取信息
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
    public void deleteById(@PathVariable("id") Integer resourceid){ shoppingcartRepository.deleteById(resourceid);
    }
}
