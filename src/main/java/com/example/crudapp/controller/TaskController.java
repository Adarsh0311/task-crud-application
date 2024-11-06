package com.example.crudapp.controller;

import com.example.crudapp.DTO.TaskDTO;
import com.example.crudapp.model.Task;
import com.example.crudapp.service.TaskService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/task")
@CrossOrigin(origins = "*")
public class TaskController {

    private final TaskService taskService;
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<TaskDTO> getTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public Task getTask(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    @PostMapping
    public Task createTask(@RequestPart("task") Task task,
                           @RequestPart(value = "files", required = false) List<MultipartFile> files) {
        return taskService.saveTask(task, files);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTaskById(id);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task task) {
        return taskService.updateTask(task, id);
    }

    @GetMapping("/search")
    public List<Task> searchTask(
            @RequestParam(name = "query") String query,
            @RequestParam(name = "priority", required = false) String priority,
            @RequestParam(name = "status", required = false) String status) {
        return taskService.searchTasks(query, status, priority);
    }
}
