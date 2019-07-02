package com.tts.ToDo.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.TestContext;
//import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;

import com.tts.ToDo.model.Task;
import com.tts.ToDo.service.TaskService;



@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {TestContext.class, WebAppContext.class})
@ContextConfiguration(classes=TestContext.class)

@WebAppConfiguration
//@RunWith(SpringRunner.class)
@WebMvcTest(TaskController.class)
public class TaskControllerTest  {
	
	@Autowired
    private MockMvc mockMvc;
	
	@Mock
    Model model;
	
	@Mock
    private TaskService taskService;
	
	TaskController controller;
	
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        controller = new TaskController(taskService);
    }
    
    @Test
    public void testMockMVC() throws Exception {
    	
    	mockMvc.perform(get("/"))
        .andExpect(status().isOk())
        .andExpect(view().name("index"));
    	
    }

	@Test
	public void testGetIndex() throws Exception {
		//given
		long millis=System.currentTimeMillis();  
		Date today = new Date(millis);
		Task task1 = new Task(1L,"creator1","title1","description1","New",today);
		Task task2 = new Task(2L,"creator2","title2","description2","In Progress",today);
		
		when(taskService.findAll()).thenReturn(Arrays.asList(task1,task2));
		
		
		ArgumentCaptor<List<Task>> argumentCaptor = ArgumentCaptor.forClass(ArrayList.class);
		
		//when
        String viewName = controller.getIndex(model);
		
        //then
        assertEquals("index", viewName);
		verify(taskService, times(1)).findAll();
        verify(model, times(1)).addAttribute(eq("taskList"), argumentCaptor.capture());
        List<Task> listInController = argumentCaptor.getValue();
        assertEquals(2, listInController.size());
        
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
	public void testGetDeletePage() {
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
