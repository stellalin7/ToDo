package com.tts.ToDo.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.tts.ToDo.model.Status;
import com.tts.ToDo.model.Task;
//import com.tts.ToDo.model.User;
import com.tts.ToDo.repository.TaskRepository;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> findAll() {
        List<Task> tasks = taskRepository.findAllByOrderByCreatedAtDesc();
        return tasks;
    }
	
//    public List<Task> findAllByUser(String creator) {
//        List<Task> tasks = taskRepository.findAllByCreatorOrderByCreatedAtDesc(creator);
//        return tasks;
//    }
//	
//    
//    
//    public List<Task> findAllByStatusOrderByCreatedAtDesc(String status){
//    	List<Task> tasks = taskRepository.findAllByStatusOrderByCreatedAtDesc(status);
//    	return tasks;
//   }	
	
    public void save(Task task) {
        taskRepository.save(task);
    }
    
    public void deleteById(Long id) {
    	taskRepository.deleteById(id);
    }
    
    public Task findById(Long id) {
    	Long[] idArray = {id, id};
    	List <Long> idList = Arrays.asList(idArray);
    	List <Task> taskList= (List<Task>) taskRepository.findAllById(idList);
    	//when statement in Mockito returns Optional Task instead of Task below
    	//Task task = taskRepository.findById(id).get();
    	//Task task = taskRepository.findById(id).orElse(null);
    	//return task;
    	return taskList.get(0);
    }
}




