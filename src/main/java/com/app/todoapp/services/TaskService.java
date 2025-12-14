package com.app.todoapp.services;

import com.app.todoapp.models.Task;
import com.app.todoapp.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@Service Annotation in Spring Boot
//The @Service annotation is used to indicate that a class belongs to the service layer in an application. The service layer typically contains the business logic of the application. The @Service annotation is a specialization of the @Component annotation, meaning that classes annotated with @Service are automatically detected during classpath scanning.
//
//Key Points about @Service annotation:
//
//It is used to mark a class as a service provider.
//It is applied only to classes.
//It is part of the stereotype annotations in Spring (along with @Controller, @Repository, and @Component).
//Spring context will autodetect these classes when annotation-based configuration and classpath scanning are used.
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public void createTask(String title) {
        Task task = new Task();
        task.setTitle(title);
        task.setCompleted(false);
        taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public void toggleTask(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("invalid task id"));
        task.setCompleted(!task.isCompleted());
        taskRepository.save(task);
    }
}

