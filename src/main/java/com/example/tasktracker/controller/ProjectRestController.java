package com.example.tasktracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tasktracker.entity.ProjectEntity;
import com.example.tasktracker.repository.ProjectRepository;
import java.util.List;


@RestController
@RequestMapping("/api/projects")
public class ProjectRestController {

    @Autowired
    private ProjectRepository projectRepo;

    @GetMapping
    public List<ProjectEntity> getAllProjects() {
        return projectRepo.findAll();
    }

    @PostMapping
    public ProjectEntity createProject(@RequestBody ProjectEntity project) {
        return projectRepo.save(project);
    }
}