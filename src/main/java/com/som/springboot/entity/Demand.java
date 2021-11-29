package com.som.springboot.entity;

import lombok.Data;
import lombok.Generated;

import javax.persistence.*;


@Entity
@Data
@Table(name = "demand")
public class Demand {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)               //主键自增
    @Column(name = "id")
    private Integer id;

    @Column(name = "demandName")
    private String demandName;

    @Column(name = "demandForm")
    private String demandForm;

    @Column(name = "demandType")
    private String demandType;

    @Column(name = "model")
    private String model;

    @Column(name = "contact")
    private String contact;

    @Column(name = "compony")
    private String compony;

    @Column(name = "open")
    private String open;

    @Column(name = "imgUrl")
    private String imgUrl;
}