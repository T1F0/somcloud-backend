package com.som.springboot.entity;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "putstoreorder")
public class PutStoreOrder {

    @Id
    @Column(name = "putstoreorderid")
    private Integer putstoreorderid;

    @Column(name = "storeid")
    private String storeid;

    @Column(name = "storename")
    private String storemane;

    @Column(name = "putstoredate")
    private String putstoredate;

    @Column(name = "remark")
    private String remark;
}
