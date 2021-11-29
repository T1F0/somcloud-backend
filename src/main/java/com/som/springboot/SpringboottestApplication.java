package com.som.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan ("com.som.springboot.mapper")
@SpringBootApplication
public class SpringboottestApplication{

    public static void main(String[] args) {
        SpringApplication.run(SpringboottestApplication.class, args);
    }
}
