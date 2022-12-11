package com.github.mnemalotebya.springbootshoppinglist.service.task;

import com.github.mnemalotebya.springbootshoppinglist.model.TaskRepository;
import com.github.mnemalotebya.springbootshoppinglist.model.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{

    private final TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public void deleteAll() {
        taskRepository.deleteAll();
    }

    @Override
    public void delete(int id) {
        taskRepository.deleteById(id);
    }

    @Override
    public void add(Task task) {
        taskRepository.save(task);
    }
}
