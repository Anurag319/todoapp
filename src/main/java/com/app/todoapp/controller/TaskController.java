package com.app.todoapp.controller;

import com.app.todoapp.models.Task;
import com.app.todoapp.services.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
//@Controller Annotation in Spring Boot
//The @Controller annotation is a specialized form of the @Component annotation in the Spring Framework. It is used to mark a class as a Spring MVC Controller, responsible for handling web requests and returning responses.
//
//Key Points:
//It is a part of the Spring MVC architecture.
//It is typically used with @RequestMapping to map HTTP requests to specific methods.
//It can only be applied at the class level.
//During component scanning, Spring automatically detects and registers classes annotated with @Controller.

@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping // @GetMapping annotation in Spring is a powerful for building RESTful web services. It maps HTTP GET requests to a specific handler method in Spring controllers.
    public String getTasks(Model model){
        List<Task> tasks = taskService.getAllTasks();
        model.addAttribute("tasks",tasks);
        return "tasks"; // this is a html page
    }
}
