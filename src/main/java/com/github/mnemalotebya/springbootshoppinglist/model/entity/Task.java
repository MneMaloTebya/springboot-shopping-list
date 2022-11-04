package com.github.mnemalotebya.springbootshoppinglist.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

@Entity
@Table(name = "tasks")
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "description", columnDefinition = "VARCHAR(50)", nullable = false)
    private String description;

    @Column(name = "date", columnDefinition = "DATETIME(6)", nullable = false)
    private LocalDateTime date;

    @OneToMany(mappedBy = "task")
    private List<Product> products;

    public Task() {
        setDate(LocalDateTime.now());
    }

}
