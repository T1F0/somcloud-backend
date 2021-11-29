package com.som.springboot.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Data
@Table(name = "order")
public class WorkOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "resourceId")
    private int resourceId;

    @Column(name = "demandId")
    private int demandId;

    @Column(name = "status")
    private int status;

    @Column(name = "createUserId")
    private int createUserId;

    @Column(name = "createTime")
    private String createTime;

    @Column(name = "adminConfirmTime")
    private String adminConfirmTime;

    @Column(name = "scheme")
    private String scheme;

    @Column(name = "adminSubmitTime")
    private String adminSubmitTime;

    @Column(name = "consumerConfirmTime")
    private String consumerConfirmTime;

    @Column(name = "adminAssignTime")
    private Date adminAssignTime;


}
