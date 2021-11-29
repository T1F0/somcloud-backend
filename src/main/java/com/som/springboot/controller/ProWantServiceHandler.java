package com.som.springboot.controller;

import com.som.springboot.entity.ProWantService;
import com.som.springboot.repository.ProWantServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/prowantservice")                //从数据库里找同名的表名
public class ProWantServiceHandler {
    @Autowired
    private ProWantServiceRepository prowantserviceRepository;

    @GetMapping("/findAll/{page}/{size}")                                   //R
    public Page<ProWantService> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        Pageable pageable= PageRequest.of(page-1,size);
        return prowantserviceRepository.findAll(pageable);
    }

    @PostMapping("/save")                         //C
    public String save(@RequestBody ProWantService prowantservice){
        ProWantService result = prowantserviceRepository.save(prowantservice);
        if(result != null){
            return "success";
        }else{
            return "error";
        }
    }

    @GetMapping("/findById/{id}")                                //通过id调取信息   U
    public ProWantService findById(@PathVariable("id") Integer demandid) {
        return prowantserviceRepository.findById(demandid).get();                    //从仓库中通过id调取信息
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
    public void deleteById(@PathVariable("id") Integer demandid){ prowantserviceRepository.deleteById(demandid);
    }
}
