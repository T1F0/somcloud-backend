package com.som.springboot.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class ProWantService {
    @Id                  //主键自增：@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String demandName;
    private String demandForm;
    private String demandType;
    private String model;
    private String contact;
    private String compony;
    private String open;
    private String imgUrl;
}
