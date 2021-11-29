//package com.som.springboot.controller;
//
//import com.som.springboot.entity.Resource;
//import com.som.springboot.mapper.ResourceMapper;
//import com.som.springboot.repository.ResourceRepository;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@Slf4j
//@RestController
//@RequestMapping("/resource")                //从数据库里找同名的表名
//public class ResourceHandler2 {
//    @Autowired
//    private ResourceRepository resourceRepository;
//    private ResourceMapper resourceMapper;
//    private Integer resourceid;
//    private String createuserid;
//    private String Arr;
//
//    @GetMapping("/findAll/{page}/{size}")                                   //R
//    public Page<Resource> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
//        Pageable pageable= PageRequest.of(page-1,size);
//        return resourceRepository.findAll(pageable);
//    }
//
//    @GetMapping("/findAll")                                   //备用（不分页）
//    public List<Resource> findAll(){
//        return resourceRepository.findAll();
//    }
//
//    @GetMapping("find")                                   //备用（不分页）
//    public List<Resource> find(String createuserid){
//        Resource record = new Resource();
////        record.setCreateuserid(createuserid);
////        String[] str = new String[];
//        record.setCreateuserid(createuserid);
//        return resourceMapper.selectResource(record);
//
//    }
//
////    public   String[]   getString()
////    {
////        String[]   str   =   new   String[n];
////        return   str;
////    }
////
////
////    @GetMapping("login")
////    public User login(Integer userid, String userName, String password){
////        User user = userMapper.selectUser(userName);
////        if (user==null){
////            return null;
////        }
////        if(Objects.equals(password, user.getPassword())){
////            user.setToken(JwtUtil.createToken());   //添加token
//////            user.getUserid(Integer userid);
////            return user;
//////            return userName;
////        }
////        return null;
//////        return "登录失败，密码错误";
////    }
//
//
////    @GetMapping("findAll")
////    public List<Resource> findAll(){
////        return resourceRepository.findAll();
////    }
//
////    @GetMapping("sort")
////    public List<Resource> sort(){
////        return resourceRepository.()
////                if
////    }
//
////    @GetMapping("sort")
////    public String sort(String[] args) {
////            Integer[] arr={9,8,7,6,5,4,3,2,1};
////            Arrays.sort(arr,Collections.reverseOrder());
////            for(int i:arr){
////                System.out.println(i);
////            }
////            return i;
////        }
//
//
////    Collections.sort(impItemList, new Comparator<ImpItem>() {
////        @Override
////        public int compare(ImpItem o1, ImpItem o2) {
////            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
////            try {
////                Date dt1 = format.parse(o1.getTransactionTime());
////                Date dt2 = format.parse(o2.getTransactionTime());
////                if (dt1.getTime() > dt2.getTime()) {
////                    return 1;
////                } else if (dt1.getTime() < dt2.getTime()) {
////                    return -1;
////                } else {
////                    return 0;
////                }
////            } catch (Exception e) {
////                e.printStackTrace();
////            }
////            return 0;
////        }
////    });
//    @PostMapping("/save")                         //C
//    public String save(@RequestBody Resource resource){
//        Resource result = resourceRepository.save(resource);
//        if(result != null){
//            return "success";
//        }else{
//            return "error";
//        }
//    }
//
//    @GetMapping("/findById/{id}")                                                                                     //通过id调取信息   U
//    public Resource findById(@PathVariable("id") Integer resourceid) {
//        return resourceRepository.findById(resourceid).get();                                                                   //从仓库中通过id调取信息
//    }
//
////    @GetMapping("findAllById/{createuserid}")
////    public List<Resource> findAById(@PathVariable("createuserid") Iterable<Integer> createuserid) {
////        return resourceRepository.findById(createuserid);
////    }
//
////    @GetMapping("/findByIdd/{id}")
////    public List<Resource> findByIdd(@PathVariable("id") Integer id) {
////        return resourceRepository.findById();
////    }
//
//
////    @GetMapping("/findByName/{brand}")
////    public List<Car> findByName( String brand) {
////        return carRepository.findByName(brand).get();                    //从仓库中通过id调取信息
////    }
//
////    @GetMapping("/categories/{brand}")
////    public List<Car> listByCategory(@PathVariable("brand") String brand) throws Exception {
//////        if (0 != cid) {
////            return carRepository.listByCategory(brand);
////        } else {
////            return list();
////        }
////    }
//
//    @DeleteMapping("/deleteById/{id}")              //D
//    public void deleteById(@PathVariable("id") Integer id){
//        resourceRepository.deleteById(id);
//    }
//}
