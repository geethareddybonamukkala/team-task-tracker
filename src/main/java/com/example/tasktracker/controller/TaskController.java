package com.example.tasktracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.tasktracker.entity.ProjectEntity;
import com.example.tasktracker.entity.TaskEntity;
import com.example.tasktracker.entity.UserEntity;
import com.example.tasktracker.repository.ProjectRepository;
import com.example.tasktracker.repository.TaskRepository;
import com.example.tasktracker.repository.UserRepository;
import com.example.tasktracker.service.TaskService;

@Controller
public class TaskController {

	 @Autowired
	    private TaskService taskService;

	    @Autowired
	    private UserRepository userRepo;

	    @Autowired
	    private ProjectRepository projectRepo;
	    
	    @Autowired
	    private TaskRepository taskRepo;;

	    @GetMapping("/viewTask")
	    public String viewTasks(Model model){
	        model.addAttribute("tasks", taskService.getAllTasks());
	        return "viewTask";
	    }

	    @GetMapping("/addTask")
	    public String addTask(Model model){
	        model.addAttribute("task", new TaskEntity());
	        model.addAttribute("users", userRepo.findAll());
	        model.addAttribute("projects", projectRepo.findAll());
	        return "add-task";
	    }

	    @PostMapping("/saveTask")
	    public String saveTask(@ModelAttribute TaskEntity task){

	        if(task.getUser()!=null && task.getUser().getId()!=null){
	            task.setUser(userRepo.findById(task.getUser().getId()).orElse(null));
	        }

	        if(task.getProject()!=null && task.getProject().getId()!=null){
	            task.setProject(projectRepo.findById(task.getProject().getId()).orElse(null));
	        }

	        // IMPORTANT FIX
	        if(task.getStatus()==null || task.getStatus().isEmpty()){
	            task.setStatus("TO_DO");
	        }

	        taskService.saveTask(task);

	        return "redirect:/viewTask";
	    }

	    @GetMapping("/deleteTask/{id}")
	    public String deleteTask(@PathVariable Long id){
	        taskService.deleteTask(id);
	        return "redirect:/viewTask";
	    }
	    
	    @GetMapping("/updateStatus/{id}/{status}")
	    public String updateStatus(@PathVariable Long id,
	                               @PathVariable String status) {

	        TaskEntity task = taskRepo.findById(id).orElseThrow();

	        task.setStatus(status);

	        taskRepo.save(task);

	        return "redirect:/viewTask";
	    }
	    
	    @GetMapping("/viewTaskDetails/{id}")
	    public String viewTaskDetails(@PathVariable Long id, Model model){

	        TaskEntity task = taskRepo.findById(id).orElseThrow();

	        model.addAttribute("task", task);

	        return "task-details";
	    }
	    
	    
	}
