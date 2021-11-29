package com.som.springboot.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class ConCollect {
    @Id                  //主键自增：@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer resourceid;
    private String userid;
    private String number;
}
