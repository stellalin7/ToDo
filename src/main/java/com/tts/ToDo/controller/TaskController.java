package com.tts.ToDo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.tts.ToDo.model.Task;
//import com.tts.ToDo.model.User;
import com.tts.ToDo.service.TaskService;
//import com.tts.ToDo.service.UserService;

@Controller
public class TaskController {
    //@Autowired
    //private UserService userService;
	
    @Autowired
    private TaskService taskService;
    
    @GetMapping(value= {"/tasks", "/"})
    public String getIndex(Model model){
        List<Task> tasks = taskService.findAll();
        model.addAttribute("taskList", tasks);
        return "index";
    }
    
    @GetMapping("/tasks/view/{id}")
	public String viewTask (@PathVariable Long id, Model model) {
		model.addAttribute("task", taskService.findById(id));
        return "view";	
    }
    
    @GetMapping("/tasks/{id}")
	public String getEditPage (@PathVariable Long id, Model model) {
		model.addAttribute("task", taskService.findById(id));
        return "edit";	
    }
    
    @PutMapping("/tasks/{id}")
    public String submitUpdate(@PathVariable Long id, Task task, Model model) {
    	Task original = taskService.findById(id);
    	original.setTitle(task.getTitle());
    	original.setCreator(task.getCreator());
    	original.setDescription(task.getDescription());
    	original.setStatus(task.getStatus());
    	taskService.save(original);
    	model.addAttribute("task", taskService.findById(id));
    	model.addAttribute("successMessage", "Task successfully updated");
    	return "edit";
    }
    
    @DeleteMapping("/tasks/{id}")
    //@RequestMapping(value = "/blog_posts/{id}", method = RequestMethod.DELETE)
    public String deletePostWithId(@PathVariable Long id, Task task, Model model) {
        taskService.deleteById(id);
        List<Task> tasks = taskService.findAll();
        model.addAttribute("taskList", tasks);
        return "index";
    }

    
    @GetMapping(value = "/tasks/new")
    public String getTaskForm(Model model) {
    	//User user = userService.getLoggedInUser();
        //model.addAttribute("task", new Task(user));
        model.addAttribute("task", new Task());
        return "newTask";
    }

    @PostMapping(value = "/tasks")
    public String createTask(@Valid Task task,  Model model) {
        //task.setUser(user);
        taskService.save(task);
        model.addAttribute("successMessage", "Task successfully created!");
        model.addAttribute("task", new Task());
        return "newTask";
    }
    
    
}
