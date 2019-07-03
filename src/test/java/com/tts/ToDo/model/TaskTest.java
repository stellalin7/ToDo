package com.tts.ToDo.model;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;



public class TaskTest {
	
	Task task;
	
	@Before
	public void setUp() {
		task = new Task();
	}

	@Test
	public void testTask() {
		assertNotNull(task);
	}

	@Test
	public void testTaskLongStringStringStringStringDate() {
		long millis=System.currentTimeMillis();  
		Date today = new Date(millis);
		Long id = 1L;
		Task task1 = new Task(1L,"creator1","title1","description1","Not Started",today);
		assertEquals(task1.getId(),id);
		assertEquals(task1.getCreator(),"creator1");
		assertEquals(task1.getTitle(),"title1");
		assertEquals(task1.getDescription(),"description1");
		assertEquals(task1.getStatus(),"Not Started");
		assertEquals(task1.getCreatedAt(), today);
	}
	
	@Test
	public void testGetId() {
		Long id = 1L;
		task.setId(id);
		assertEquals(id,task.getId());
	}
	
	@Test
	public void testSetId() {
		Long id = 2L;
		task.setId(id);
		assertEquals(id,task.getId());
	}

	@Test
	public void testGetCreator() {
		String creator = "creator1";
		task.setCreator(creator);
		assertEquals(task.getCreator(),creator);
	}

	@Test
	public void testSetCreator() {
		String creator = "creator2";
		task.setCreator(creator);
		assertEquals(task.getCreator(),creator);
	}
	
	@Test
	public void testGetTitle() {
		
		String title = "title1";
		task.setTitle(title);
		assertEquals(title,task.getTitle());
		
	}

	@Test
	public void testSetTitle() {
		String title = "title2";
		task.setTitle(title);
		assertEquals(title,task.getTitle());
	}

	@Test
	public void testGetDescription() {
		String description = "description1";
		task.setDescription(description);
		assertEquals(description,task.getDescription());
	}

	@Test
	public void testSetDescription() {
		String description = "description2";
		task.setDescription(description);
		assertEquals(description,task.getDescription());
	}
	
	@Test
	public void testGetStatus() {
		String status = "In Progress";
		task.setStatus(status);
		assertEquals(task.getStatus(),status);
	}

	@Test
	public void testSetStatus() {
		String status = "Complete";
		task.setStatus(status);
		assertEquals(task.getStatus(),status);
	}


	@Test
	public void testGetCreatedAt() {
		long millis=System.currentTimeMillis();  
		Date today = new Date(millis);
		task.setCreatedAt(today);
		assertEquals(task.getCreatedAt(),today);
	}
	
	@Test
	public void testSetCreatedAt() {
		long millis=System.currentTimeMillis();  
		Date now = new Date(millis);
		task.setCreatedAt(now);
		assertEquals(task.getCreatedAt(),now);
	}

	
	

}
