package com.som.springboot.controller;

import com.som.springboot.entity.UserData;
import com.som.springboot.repository.UserDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userdata")                //从数据库里找同名的表名
public class UserDataHandler {
    @Autowired
    private UserDataRepository userdataRepository;

    @GetMapping("/findAll")                                   //备用（不分页）
    public List<UserData> findAll(){
        return userdataRepository.findAll();
    }

    @PostMapping("/save")                         //C
    public String save(@RequestBody UserData userdata){
        UserData result = userdataRepository.save(userdata);
        if(result != null){
            return "成功";
        }else{
            return "出错";
        }
    }

    @GetMapping("/findById/{id}")                                //通过id调取信息   U
    public UserData findById(@PathVariable("id") Integer userid) {
        return userdataRepository.findById(userid).get();                    //从仓库中通过id调取信息
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
    public void deleteById(@PathVariable("id") Integer userid){ userdataRepository.deleteById(userid);
    }
}
