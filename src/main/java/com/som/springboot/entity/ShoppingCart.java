package com.som.springboot.entity;

import lombok.Data;

import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class ShoppingCart {
    @Id                  //主键自增：@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer resourceid;

    private Integer userid;
    private Integer number;
}
