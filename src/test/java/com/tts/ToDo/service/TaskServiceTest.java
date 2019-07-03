package com.tts.ToDo.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;
//import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.tts.ToDo.model.Task;
import com.tts.ToDo.repository.TaskRepository;

@RunWith(SpringRunner.class)
public class TaskServiceTest {
	
	@TestConfiguration
    static class TaskServiceTestContextConfiguration {
  
        @Bean
        public TaskService employeeService() {
            return new TaskService();
        }
    }
	
	@Autowired
    private TaskService taskService;
 
    @MockBean
    private TaskRepository taskRepository;
    
    
 

	@Test
	public void testFindAll() {
		//given
		long millis=System.currentTimeMillis();  
		Date today = new Date(millis);
		Task task1 = new Task(1L,"creator1","title1","description1","Not Started",today);
		Task task2 = new Task(2L,"creator2","title2","description2","In Progress",today);
		
		when(taskRepository.findAllByOrderByCreatedAtDesc()).thenReturn(Arrays.asList(task1,task2));
		
		//when
		List<Task> tasks=taskService.findAll();
		
		//then
		assertEquals(tasks.size(), 2);
		verify(taskRepository, times(1)).findAllByOrderByCreatedAtDesc();
		
	}

	@Test
	public void testSave() {
		//given
		long millis=System.currentTimeMillis();  
		Date today = new Date(millis);
		Task task2 = new Task(2L,"creator2","title2","description2","In Progress",today);
		
		//when(taskRepository.save(task2)).thenReturn(task2);
		
		//when
		taskService.save(task2);
		
		//then
		verify(taskRepository, times(1)).save(task2);
	}

	@Test
	public void testDeleteById() {
		//when
		taskService.deleteById(1L);
		
		//then
		verify(taskRepository, times(1)).deleteById(1L);
	
	}

	@Test
	public void testFindById() {
		//given
		long millis=System.currentTimeMillis();  
		Date today = new Date(millis);
		Long id = 2L;
		Task task2 = new Task(id,"creator2","title2","description2","In Progress",today);
		
		Long[] idArray = {id, id};
    	List <Long> idList = Arrays.asList(idArray);
		
		when(taskRepository.findAllById(idList)).thenReturn(Arrays.asList(task2,task2));
		
		//when
		Task task = taskService.findById(2L);
		
		//then
		verify(taskRepository, times(1)).findAllById(idList);
		assertEquals(task.getCreator(),"creator2");
		assertEquals(task.getTitle(),"title2");
		assertEquals(task.getDescription(),"description2");
		assertEquals(task.getStatus(),"In Progress");
		assertEquals(task.getCreatedAt(),today);
	}

}
