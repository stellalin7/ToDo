package com.tts.ToDo.repository;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TaskRepositoryTest {
	
	@Autowired
    private TestEntityManager entityManager;
 
    @Autowired
    private TaskRepository taskRepository;

	@Test
	public void testFindAllByOrderByCreatedAtDesc() {
		fail("Not yet implemented");
	}

}
