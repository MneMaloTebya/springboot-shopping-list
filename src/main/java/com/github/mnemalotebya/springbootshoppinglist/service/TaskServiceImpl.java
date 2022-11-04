package com.github.mnemalotebya.springbootshoppinglist.service;

import com.github.mnemalotebya.springbootshoppinglist.model.TaskRepository;
import com.github.mnemalotebya.springbootshoppinglist.model.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService{

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<Task> getAllTask() {
        return taskRepository.findAll();
    }

    @Override
    public Task getTaskById(int id) {
        Task task;
        Optional<Task> optional = taskRepository.findById(id);
        if (optional.isPresent()) {
            task = optional.get();
            return task;
        }
        return null;
    }

    @Override
    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public void deleteTaskById(int id) {
        taskRepository.deleteById(id);
    }

    @Override
    public void deleteAllTask() {
        taskRepository.deleteAll();
    }
}
