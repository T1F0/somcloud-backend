package com.som.springboot.controller;

import com.som.springboot.entity.Demand;
import com.som.springboot.mapper.DemandMapper;
import com.som.springboot.repository.DemandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("demand")                //从数据库里找同名的表名
public class DemandHandler {
    @Autowired
    private DemandRepository demandRepository;
    @Autowired
    private DemandMapper demandMapper;

    @GetMapping("/findAll/{page}/{size}")                                   //R
    public Page<Demand> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        Pageable pageable= PageRequest.of(page-1,size);
        return demandRepository.findAll(pageable);
    }

    @PostMapping("/save")                         //C
    public String save(@RequestBody Demand demand){
        Demand result = demandRepository.save(demand);
        if(result != null){
            return "success";
        }else{
            return "error";
        }
    }

    @GetMapping("/findById/{id}")                                //通过id调取信息   U
    public Demand find(@PathVariable("id") Integer id) {
        return demandMapper.findById(id);                    //从仓库中通过id调取信息
    }

    @GetMapping("/findAll")
    public List<Demand> find() {
        return demandMapper.findAll();
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
    public void deleteById(@PathVariable("id") Integer demandid){ demandRepository.deleteById(demandid);
    }

    
}
