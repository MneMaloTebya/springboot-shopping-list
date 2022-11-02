package com.github.mnemalotebya.springbootshoppinglist.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

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

    @Column(name = "date", columnDefinition = "DATETIME", nullable = false)
    private LocalDateTime date;

    public Task() {
        setDate(LocalDateTime.now());
    }
}
