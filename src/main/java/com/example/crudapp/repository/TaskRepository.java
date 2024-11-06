package com.example.crudapp.repository;

import com.example.crudapp.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>, JpaSpecificationExecutor<Task> {

    @Query("select t from Task t order by t.id DESC ")
    List<Task> findAll();

    Optional<Task> findByTitle(String title);


    List<Task> findTaskByTitleLikeIgnoreCaseOrDescriptionLikeIgnoreCase(String title, String description);

    //This is new way to write multi-line query in java 17 without placing +
    @Query("""
            SELECT t from Task t where LOWER(t.title) like LOWER(concat('%',:query,'%')) 
            OR LOWER(t.description) like LOWER(concat('%', :query, '%') ) ORDER BY t.id DESC""")
    List<Task> findByTitleOOrDescription(String query);
}
