package com.example.crudapp.DTO;

import com.example.crudapp.model.Task;
import com.example.crudapp.model.TaskFile;

import java.util.Date;
import java.util.List;

public class TaskDTO {
    private Long id;
    private String title;
    private String description;
    private Task.Status status;
    private Date dueDate;
    private Task.Priority priority;
    private List<TaskFile> files;

    public TaskDTO() {
    }

    public TaskDTO(Long id, String title, String description, Task.Status status, Date dueDate, Task.Priority priority, String fileName, String fileType, byte[] fileData) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.dueDate = dueDate;
        this.priority = priority;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Task.Status getStatus() {
        return status;
    }

    public void setStatus(Task.Status status) {
        this.status = status;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Task.Priority getPriority() {
        return priority;
    }

    public void setPriority(Task.Priority priority) {
        this.priority = priority;
    }

    public List<TaskFile> getFiles() {
        return files;
    }

    public void setFiles(List<TaskFile> files) {
        this.files = files;
    }
}
