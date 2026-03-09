package com.example.tasktracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.tasktracker.entity.UserEntity;
import com.example.tasktracker.repository.UserRepository;

@Controller
public class UserController {

	    @Autowired
	    private UserRepository userRepo;
	    
	    @GetMapping("/addUser")
	    public String addUser(Model model){
	        model.addAttribute("user", new UserEntity());
	        return "add-user";
	    }

	    @PostMapping("/saveUser")
	    public String saveUser(@ModelAttribute UserEntity user){
	        userRepo.save(user);
	        return "redirect:/viewUsers";
	    }

	    @GetMapping("/viewUsers")
	    public String viewUsers(Model model){
	        model.addAttribute("users", userRepo.findAll());
	        return "view-users";
	    }

	    @GetMapping("/deleteUser/{id}")
	    public String deleteUser(@PathVariable Long id){
	        userRepo.deleteById(id);
	        return "redirect:/viewUsers";
	    }
	
	}
	    
	    

