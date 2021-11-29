package com.som.springboot.entity;

import lombok.Data;
import org.hibernate.query.criteria.internal.predicate.PredicateImplementor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.PrimitiveIterator;


@Entity
@Data
@Table(name = "product")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private String price;

    @Column(name = "detail")
    private String detail;
}
