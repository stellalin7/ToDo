package com.tts.ToDo.repository;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.sql.Date;
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
	
//	@Autowired
//    private TestEntityManager entityManager;
// 
    @Autowired
    private TaskRepository taskRepository;

	@Test
	public void testFindAllByOrderByCreatedAtDesc() {
		
		//given
		long millis=System.currentTimeMillis();  
		Date now = new Date(millis);
		Date before = new Date(millis-1000);
		Task task1 = new Task(1L,"creator1","title1","description1","Not Started",now);
		Task task2 = new Task(2L,"creator2","title2","description2","In Progress",before);
		taskRepository.save(task1);
		taskRepository.save(task2);

		//when		
		List<Task> tasks = taskRepository.findAllByOrderByCreatedAtDesc();
		
		//then
		assertEquals(2, tasks.size());
		//assertEquals(now, tasks.get(0).getCreatedAt());
		assertEquals("Not Started", tasks.get(0).getStatus());
		//assertEquals(now, tasks.get(0).getCreatedAt());
		assertEquals("In Progress", tasks.get(1).getStatus());
		
	}

}
