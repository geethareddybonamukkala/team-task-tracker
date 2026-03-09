package com.example.tasktracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tasktracker.entity.TaskEntity;
import com.example.tasktracker.repository.TaskRepository;

@Service
public class TaskService {
       @Autowired
	private TaskRepository taskRepo;
       
       
       public TaskEntity saveTask(TaskEntity task) {
    	   return taskRepo.save(task);
       }
       
       
       public List<TaskEntity> getAllTasks() {
    	   return taskRepo.findAll();
       }
       
       public void deleteTask(Long id) {
    	   taskRepo.deleteById(id);
       }
       
//     public TaskEntity getTaskById(Long id) {
//    	 return taskRepo.findById(id).orElse(null);
//     }
}
