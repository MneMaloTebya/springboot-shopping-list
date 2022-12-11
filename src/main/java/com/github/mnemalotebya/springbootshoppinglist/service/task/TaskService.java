package com.github.mnemalotebya.springbootshoppinglist.service.task;

import com.github.mnemalotebya.springbootshoppinglist.model.entity.Task;

import java.util.List;

public interface TaskService {
    List<Task> findAll();
    void deleteAll();
    void delete(int id);
    void add(Task task);
}
