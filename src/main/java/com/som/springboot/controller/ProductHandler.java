package com.som.springboot.controller;

import com.som.springboot.entity.Product;
import com.som.springboot.entity.Result;
import com.som.springboot.mapper.ProductMapper;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("product")
public class ProductHandler {

    @Autowired
    private ProductMapper productMapper;

    @GetMapping("/findById")
    public Product find(Integer id){
        return productMapper.findById(id);
    }

    @GetMapping("/findAll")
    public List<Product> find(){
        return productMapper.findAll();
    }

    @GetMapping("/findByTotal")
    public Result[] compute(BigDecimal totalPrice){
        Result[] result = new Result[10];
        int index = 0;
        List<Product> products= productMapper.findAll();
        for (int firstProductId = 1; firstProductId < products.toArray().length;firstProductId++){
            BigDecimal firstProductPrice = new BigDecimal(products.get(firstProductId - 1).getPrice());
            if(firstProductPrice.compareTo(totalPrice) > 0){
                continue;
            }
            for (int secondProductId = firstProductId + 1; secondProductId < products.toArray().length + 1;secondProductId++){
                BigDecimal secondProductPrice = new BigDecimal(products.get(secondProductId - 1).getPrice());
                if ((firstProductPrice.add(secondProductPrice)).compareTo(totalPrice) == 0){
                    result[index] = new Result();
                    result[index].setFirstProduct(firstProductId);
                    result[index].setSecondProduct(secondProductId);
                    index++;
                }
            }
        }
        return result;
    }

    @GetMapping("/fuzzyFindByTotal")
    public Result[] compute(BigDecimal minPrice,BigDecimal maxPrice){
        Result[] result = new Result[10];
        int index = 0;
        List<Product> products= productMapper.findAll();
        for (int firstProductId = 1; firstProductId < products.toArray().length;firstProductId++){
            BigDecimal firstProductPrice = new BigDecimal(products.get(firstProductId - 1).getPrice());
            if(firstProductPrice.compareTo(maxPrice) > 0){
                continue;
            }
            for (int secondProductId = firstProductId + 1; secondProductId < products.toArray().length + 1;secondProductId++){
                BigDecimal secondProductPrice = new BigDecimal(products.get(secondProductId - 1).getPrice());
                if ((firstProductPrice.add(secondProductPrice)).compareTo(minPrice) > 0 && (firstProductPrice.add(secondProductPrice)).compareTo(maxPrice) < 0){
                    result[index] = new Result();
                    result[index].setFirstProduct(firstProductId);
                    result[index].setSecondProduct(secondProductId);
                    index++;
                }
            }
        }
        return result;
    }
}
