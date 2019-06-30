package com.tts.ToDo.controller;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.tts.ToDo.service.TaskService;


@RunWith(SpringRunner.class)
@WebMvcTest(TaskController.class)
public class TaskControllerTest {
	
	@Autowired
    private MockMvc mockMvc;
	
	@MockBean
    private TaskService taskService;

	@Test
	public void testGetIndex() {
		fail("Not yet implemented");
	}

	@Test
	public void testViewTask() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetEditPage() {
		fail("Not yet implemented");
	}

	@Test
	public void testSubmitUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeletePostWithId() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTaskForm() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreateTask() {
		fail("Not yet implemented");
	}

}
