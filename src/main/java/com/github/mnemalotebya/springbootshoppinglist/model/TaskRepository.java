package com.github.mnemalotebya.springbootshoppinglist.model;

import com.github.mnemalotebya.springbootshoppinglist.model.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {
}
