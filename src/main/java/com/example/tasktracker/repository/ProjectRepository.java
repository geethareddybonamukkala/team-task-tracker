package com.example.tasktracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tasktracker.entity.ProjectEntity;
import com.example.tasktracker.entity.UserEntity;

public interface ProjectRepository extends JpaRepository<ProjectEntity,Long>{

}
