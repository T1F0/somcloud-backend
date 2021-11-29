package com.som.springboot.controller;

import com.som.springboot.entity.ProWantManu;
import com.som.springboot.repository.ProWantManuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/prowantmanu")                //从数据库里找同名的表名
public class ProWantManuHandler {
    @Autowired
    private ProWantManuRepository prowantmanuRepository;

    @GetMapping("/findAll/{page}/{size}")                                   //R
    public Page<ProWantManu> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        Pageable pageable= PageRequest.of(page-1,size);
        return prowantmanuRepository.findAll(pageable);
    }

    @PostMapping("/save")                         //C
    public String save(@RequestBody ProWantManu prowantmanu){
        ProWantManu result = prowantmanuRepository.save(prowantmanu);
        if(result != null){
            return "success";
        }else{
            return "error";
        }
    }

    @GetMapping("/findById/{id}")                                //通过id调取信息   U
    public ProWantManu findById(@PathVariable("id") Integer demandid) {
        return prowantmanuRepository.findById(demandid).get();                    //从仓库中通过id调取信息
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
    public void deleteById(@PathVariable("id") Integer demandid){ prowantmanuRepository.deleteById(demandid);
    }
}
