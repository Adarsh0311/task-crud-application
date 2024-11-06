package com.example.crudapp.repository;

import com.example.crudapp.model.TaskFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskFileRepository extends JpaRepository<TaskFile, Long> {
}
