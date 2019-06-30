package com.tts.ToDo;

import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tts.ToDo.controller.TaskController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ToDoApplicationTest {
	
	@Autowired
	private TaskController taskController;
	
	@Test
	public void contextLoads() throws Exception {
		assertThat(taskController).isNotNull();
	}

}
