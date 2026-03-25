package com.example.tasktracker.controller;

import com.example.tasktracker.entity.TaskEntity;
import com.example.tasktracker.repository.TaskRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

	@RestController   // IMPORTANT
	@RequestMapping("/api/tasks")
public class TaskRestController {

	    @Autowired
	    private TaskRepository taskRepo;

	    // 1️⃣ Get all tasks
	    @GetMapping
	    public List<TaskEntity> getAllTasks() {
	        return taskRepo.findAll();
	    }

	    // 2️⃣ Get task by ID
	    @GetMapping("/{id}")
	    public TaskEntity getTaskById(@PathVariable Long id) {
	        return taskRepo.findById(id).orElseThrow();
	    }

	    // 3️⃣ Create new task
	    @PostMapping
	    public TaskEntity createTask(@RequestBody TaskEntity task) {
	        return taskRepo.save(task);
	    }

	    // 4️⃣ Update task status
	    @PutMapping("/{id}/status")
	    public TaskEntity updateStatus(@PathVariable Long id,
	                                   @RequestParam String status) {

	        TaskEntity task = taskRepo.findById(id).orElseThrow();

	        task.setStatus(status);

	        return taskRepo.save(task);
	    }

	    // 5️⃣ Delete task
	    @DeleteMapping("/{id}")
	    public String deleteTask(@PathVariable Long id) {
	        taskRepo.deleteById(id);
	        return "Task Deleted Successfully";
	    }
	}

