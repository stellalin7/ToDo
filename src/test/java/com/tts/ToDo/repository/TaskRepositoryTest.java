package com.tts.ToDo.repository;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import java.sql.Date;
//import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.tts.ToDo.model.Task;

//https://www.baeldung.com/spring-boot-testing
@RunWith(SpringRunner.class)
@DataJpaTest
public class TaskRepositoryTest {
	
	@Autowired
    private TestEntityManager entityManager;
 
    @Autowired
    private TaskRepository taskRepository;

	@Test
	public void testFindAllByOrderByCreatedAtDesc() {
		
		//when		
		List<Task> tasks = taskRepository.findAllByOrderByCreatedAtDesc();
		
		//then
		verify(taskRepository, times(1)).findAllByOrderByCreatedAtDesc();
	}

}
