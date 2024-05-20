package com.binde.TaskManagementSystem.service;

import com.binde.TaskManagementSystem.dto.TaskManagementDto;

import java.util.List;

public interface TaskManagementService {
    TaskManagementDto createTask(TaskManagementDto taskManagementDto);

    TaskManagementDto getTodo(Long id);

    List<TaskManagementDto> getAllTasks();

    TaskManagementDto updateTask(TaskManagementDto taskManagementDto, Long id);

    void deleteTask(Long id);

    TaskManagementDto completeTask(Long id);

    TaskManagementDto inCompleteTask(Long id);

    TaskManagementDto inProgressTask(Long id);
}
