package com.github.mnemalotebya.springbootshoppinglist.controller;

import com.github.mnemalotebya.springbootshoppinglist.model.entity.Task;
import com.github.mnemalotebya.springbootshoppinglist.service.TaskService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MyWebController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/taskList")
    public String taskList(Model model) {
        List<Task> tasks = new ArrayList<>();
        Iterable<Task> iterable = taskService.getAllTask();
        for (Task task : iterable) {
            tasks.add(task);
        }
        model.addAttribute("tasks", tasks);
        return "taskList";
    }

    @GetMapping("/addTask")
    public String addTask(Model model) {
        model.addAttribute("task", new Task());
        return "addTask";
    }

    @PostMapping("/addTask")
    public String saveTask(@ModelAttribute("newTask") Task task) {
        List<Task> taskList = new ArrayList<>();
        String description = task.getDescription();
        if (description != null && description.length() > 0) {
            Task newTask = taskService.addTask(task);
            taskList.add(newTask);
        }
        return "redirect:/taskList";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteTaskById(@PathVariable int id) {
        taskService.deleteTaskById(id);
        return "redirect:/taskList";
    }

    @DeleteMapping("/deleteAll")
    public String deleteAllTask() {
        taskService.deleteAllTask();
        return "redirect:/taskList";
    }


    // TODO: 03.11.2022 метод работает некорректно
    @PutMapping("/updateTask")
    public String updateTask(@RequestParam("taskId") int id, Model model) {
        Task task = taskService.getTaskById(id);
        model.addAttribute("task", task);
        return "addTask";
    }
}
