package com.example.tasktracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tasktracker.entity.TaskEntity;
import com.example.tasktracker.entity.UserEntity;

public interface TaskRepository extends JpaRepository<TaskEntity,Long>{

}
