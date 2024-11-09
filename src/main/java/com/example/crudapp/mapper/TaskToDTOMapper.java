package com.example.crudapp.mapper;

import com.example.crudapp.DTO.TaskDTO;
import com.example.crudapp.model.Task;
import com.example.crudapp.model.TaskFile;

import java.util.HashMap;
import java.util.Map;

public class TaskToDTOMapper {
    private TaskToDTOMapper() {}

    public static TaskDTO mapToDTO(Task task) {
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setId(task.getId());
        taskDTO.setDescription(task.getDescription());
        taskDTO.setPriority(task.getPriority());
        taskDTO.setDueDate(task.getDueDate());
        taskDTO.setStatus(task.getStatus());
        taskDTO.setTitle(task.getTitle());

        try {
            Map<Long, String> taskFiles = new HashMap<>();
            for (TaskFile file: task.getTaskFiles()) {
                taskFiles.put(file.getId(), file.getFileName());
            }
            taskDTO.setTaskFiles(taskFiles);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return taskDTO;

    }
}
