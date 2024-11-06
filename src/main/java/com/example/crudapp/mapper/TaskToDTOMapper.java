package com.example.crudapp.mapper;

import com.example.crudapp.DTO.TaskDTO;
import com.example.crudapp.model.Task;

public class TaskToDTOMapper {
    public static TaskDTO mapToDTO(Task task) {
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setId(task.getId());
        taskDTO.setDescription(task.getDescription());
        taskDTO.setPriority(task.getPriority());
        taskDTO.setDueDate(task.getDueDate());
        taskDTO.setStatus(task.getStatus());
        taskDTO.setTitle(task.getTitle());

        try {
            taskDTO.setFiles(task.getTaskFiles());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return taskDTO;

    }
}
