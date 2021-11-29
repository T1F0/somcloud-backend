//package com.som.springboot.controller;
//
//import com.som.springboot.entity.Product;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.lang.reflect.Field;
//import java.text.Format;
//import java.util.HashMap;
//import java.util.Map;
//
//@RestController
//    @Slf4j
//    @RequestMapping(value = "/product")
//    public class ProductController {
//
//        @Autowired
//        private RedisTemplate redisTemplate;
//
//        @PostMapping(value = "/create")
//        public void create(Product obj) {
//            String key="product:"+1000;             //TODO先进db，创建商品，先把数据添加到数据库，再存入redis
//            Map<String, Object> map=this.objectToMap(obj);      //将Object对象里面的属性和值转化为Map对象
//            this.redisTemplate.opsForHash().putAll(key,map);   //批量put操作 putAll等于hmset命令
//
//            Object name=this.redisTemplate.opsForHash().get(key,"name") ;
//            log. info( "name={}", name);
//            Object price=this.redisTemplate.opsForHash() .get(key,"price");
//            log. info("price={}",price);
//            Object detail=this.redisTemplate.opsForHash().get(key,"detail");
//            log. info( "detail={}" , detail);
//        }
//
//    @PostMapping(value = "/addPrice")
//    public void addPrice(int id,int price) {
//        String key = "product:" + id;
//        this.redisTemplate.opsForHash().increment(key, "price", price);
//        Object price2 = this.redisTemplate.opsForHash().get(key, "price");
//        log.info("price={}", price2);
//    }
//
//        public Map<String, Object> objectToMap (Object obj) {                 //将Object对象里面的属性和值转化成Map对象
//        Map<String, Object> map = new HashMap<>();
//        Class<?> clazz = obj.getClass();
//        for (Field field : clazz.getDeclaredFields()) {
//            field.setAccessible(true);
//            String fieldName = field.getName() ;
//            Object value = null;
//            try {
//                value = field.get(obj);
//            } catch (IllegalAccessException e) {
//                log. error(e.getMessage());
//            }
//            map. put(fieldName, value) ;
//        }
//        return map;
//    }
//}
