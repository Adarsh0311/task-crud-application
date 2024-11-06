package com.example.crudapp.controller;

import com.example.crudapp.exception.TaskFileNotFoundException;
import com.example.crudapp.service.TaskFileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/task-file")
@CrossOrigin("*")
public class TaskFileController {

    private final TaskFileService taskFileService;

    public TaskFileController(TaskFileService taskFileService) {
        this.taskFileService = taskFileService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getTaskById(@PathVariable Long id) throws TaskFileNotFoundException {
        return taskFileService.getTaskFileById(id);
    }
}
