package com.github.mnemalotebya.springbootshoppinglist.service;

import com.github.mnemalotebya.springbootshoppinglist.model.entity.Task;

import java.util.List;

public interface TaskService {
    List<Task> getAllTask();
    Task getTaskById(int id);
    Task addTask(Task task);
    void deleteTaskById(int id);
    void deleteAllTask();
    Task updateTask(Task task);
}
