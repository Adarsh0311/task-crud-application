package com.example.crudapp.service;

import com.example.crudapp.DTO.TaskDTO;
import com.example.crudapp.exception.TaskNotFoundException;
import com.example.crudapp.mapper.TaskToDTOMapper;
import com.example.crudapp.model.Task;
import com.example.crudapp.model.TaskFile;
import com.example.crudapp.repository.TaskRepository;
import com.example.crudapp.specification.TaskSpecification;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TaskService {
    private final TaskRepository taskRepository;
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<TaskDTO> getAllTasks() {
        List<Task> taskList = taskRepository.findAll();

        return taskList.stream()
                .map(TaskToDTOMapper::mapToDTO)
                .toList();
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    public Task saveTask(Task task, List<MultipartFile> files) {
        try {

            List<TaskFile> files1 = new ArrayList<>();
            for (MultipartFile file : files) {
                TaskFile taskFile = new TaskFile();
                taskFile.setFileName(file.getOriginalFilename());
                taskFile.setFileType(file.getContentType());
                taskFile.setFileData(file.getBytes());
                taskFile.setTask(task);
                files1.add(taskFile);
            }

            task.setTaskFiles(files1);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return taskRepository.save(task);
    }

    public void deleteTaskById(Long id) {
        taskRepository.deleteById(id);
    }

    public Task updateTask(Task task, Long id) {
        Task taskToUpdate = getTaskById(id);
        if (taskToUpdate != null) {
            taskToUpdate.setDescription(task.getDescription());
            taskToUpdate.setPriority(task.getPriority());
            taskToUpdate.setTitle(task.getTitle());
            taskToUpdate.setStatus(task.getStatus());
            taskToUpdate.setDueDate(task.getDueDate());
            return taskRepository.save(taskToUpdate);

        } else {
            throw new TaskNotFoundException("Task not found");
        }
    }


    public List<Task> searchTasks(String query, String status, String priority) {
        Specification<Task> specification = Specification
                                                .where(TaskSpecification.hasStatus(status))
                                                .and(TaskSpecification.hasPriority(priority))
                                                .and(TaskSpecification.generalSearch(query));

        return taskRepository.findAll(specification);
    }
}
