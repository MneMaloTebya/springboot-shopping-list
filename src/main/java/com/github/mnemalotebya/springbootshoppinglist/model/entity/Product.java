package com.github.mnemalotebya.springbootshoppinglist.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "products")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name", columnDefinition = "VARCHAR(50)", nullable = false)
    private String name;

    @Column(name = "count", nullable = false)
    private int count;

    @Column(name = "weight")
    private float weight;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusType statusType;

}
