package com.som.springboot.entity;

import lombok.Data;
import lombok.Generated;

import javax.persistence.*;

@Entity
@Data
@Table(name = "resource")
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)             //主键自增
    @Column(name = "resourceid")
    private Integer resourceid;

    @Column(name = "createuserid")
    private String createuserid;

    @Column(name = "resourcename")
    private String resourcename;

    @Column(name = "resourceform")
    private String resourceform;

    @Column(name = "resourcetype")
    private String resourcetype;

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
