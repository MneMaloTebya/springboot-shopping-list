package com.github.mnemalotebya.springbootshoppinglist.controller;
import com.github.mnemalotebya.springbootshoppinglist.model.entity.Task;
import com.github.mnemalotebya.springbootshoppinglist.service.task.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("tasks", taskService.findAll());
        model.addAttribute("task", new Task());
        return "tasks";
    }

    @DeleteMapping("/deleteAllTask")
    public String deleteAllTask() {
        taskService.deleteAll();
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable("id") int id) {
        taskService.delete(id);
        return "redirect:/";
    }

    @PostMapping
    public String addTask(Task task) {
        taskService.add(task);
        return "redirect:/";
    }
}
