package com.tts.ToDo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//import com.tts.ToDo.model.Status;
import com.tts.ToDo.model.Task;
//import com.tts.ToDo.model.User;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {
    List<Task> findAllByOrderByCreatedAtDesc();
    List<Task> findAllByCreatorOrderByCreatedAtDesc(String creator);
    List<Task> findAllByStatusOrderByCreatedAtDesc(String status);
}

