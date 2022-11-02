package com.github.mnemalotebya.springbootshoppinglist.controller;

import com.github.mnemalotebya.springbootshoppinglist.model.entity.Task;
import com.github.mnemalotebya.springbootshoppinglist.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ShoppingListRestController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/tasks")
    public List<Task> getAllTask() {
        Iterable<Task> iterable = taskService.getAllTask();
        List<Task> tasks = new ArrayList<>();
        for (Task task : iterable) {
            tasks.add(task);
        }
        return tasks;
    }

    @GetMapping("/tasks/{id}")
    public Task getTaskById(@PathVariable int id) {
        return taskService.getTaskById(id);
    }

    @PostMapping("/tasks")
    public Task addTask(@RequestBody Task task) {
        Task newTask = taskService.addTask(task);
        return newTask;
    }

    @DeleteMapping("/tasks/{id}")
    public void deleteTaskById(@PathVariable int id) {
        taskService.deleteTaskById(id);
    }

    @DeleteMapping("/tasks")
    public void deleteAllTask() {
        taskService.deleteAllTask();
    }

    @PutMapping("/tasks")
    public Task updateTask(@RequestBody Task task) {
        return taskService.updateTask(task);
    }
}
