package com.tts.ToDo.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

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
		fail("Not yet implemented");
	}

	@Test
	public void testSave() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteById() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindById() {
		fail("Not yet implemented");
	}

}
