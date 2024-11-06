package com.example.crudapp.service;

import com.example.crudapp.exception.TaskFileNotFoundException;
import com.example.crudapp.model.TaskFile;
import com.example.crudapp.repository.TaskFileRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TaskFileService {

    private final TaskFileRepository taskFileRepository;

    public TaskFileService(TaskFileRepository taskFileRepository) {
        this.taskFileRepository = taskFileRepository;
    }

    public ResponseEntity<byte[]> getTaskFileById(Long id) throws TaskFileNotFoundException {
        TaskFile file = taskFileRepository.findById(id)
                .orElseThrow(() -> new TaskFileNotFoundException("File Not Found"));

        byte[] fileData = file.getFileData();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", file.getFileType());
        headers.add("Content-Disposition", "attachment; filename=" + file.getFileName());

        return new ResponseEntity<>(fileData, headers, HttpStatus.OK);
    }
}
