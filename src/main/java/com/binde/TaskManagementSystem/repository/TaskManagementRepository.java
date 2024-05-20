package com.binde.TaskManagementSystem.repository;

import com.binde.TaskManagementSystem.entity.TaskManagement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskManagementRepository extends JpaRepository<TaskManagement,Long> {
}
