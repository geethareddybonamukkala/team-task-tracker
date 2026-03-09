package com.example.tasktracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.tasktracker.entity.ProjectEntity;
import com.example.tasktracker.repository.ProjectRepository;

@Controller
public class ProjectController {

	 @Autowired
	    private ProjectRepository projectRepo;

	    @GetMapping("/addProject")
	    public String addProject(Model model){
	        model.addAttribute("project", new ProjectEntity());
	        return "add-project";
	    }

	    @PostMapping("/saveProject")
	    public String saveProject(@ModelAttribute ProjectEntity project){
	        projectRepo.save(project);
	        return "redirect:/viewProjects";
	    }

	    @GetMapping("/viewProjects")
	    public String viewProjects(Model model){
	        model.addAttribute("projects", projectRepo.findAll());
	        return "view-projects";
	    }

	    @GetMapping("/deleteProject/{id}")
	    public String deleteProject(@PathVariable Long id){
	        projectRepo.deleteById(id);
	        return "redirect:/viewProjects";
	    }
}
