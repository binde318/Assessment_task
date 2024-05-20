package com.binde.TaskManagementSystem.controller;

import com.binde.TaskManagementSystem.dto.TaskManagementDto;
import com.binde.TaskManagementSystem.service.TaskManagementService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/tasks")
@AllArgsConstructor
public class TaskManagementController {
    private TaskManagementService taskManagementService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create_task")
    public ResponseEntity<TaskManagementDto> createTask(@RequestBody TaskManagementDto taskManagementDto) {
        TaskManagementDto savedTask = taskManagementService.createTask(taskManagementDto);
        return new ResponseEntity<>(savedTask, HttpStatus.CREATED);
    }


    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("{id}")
    public ResponseEntity<TaskManagementDto> getTask(@PathVariable("id") Long taskId) {
        TaskManagementDto taskDto = taskManagementService.getTodo(taskId);
        return new ResponseEntity<>(taskDto, HttpStatus.OK);
    }


    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/view_all_tasks")
    public ResponseEntity<List<TaskManagementDto>> getAllTasks() {
        List<TaskManagementDto> tasks = taskManagementService.getAllTasks();

        return ResponseEntity.ok(tasks);
    }


    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @PutMapping("{id}")
    public ResponseEntity<TaskManagementDto> updateTask(@RequestBody TaskManagementDto taskManagementDto, @PathVariable("id") Long taskId) {
        TaskManagementDto updatedTask = taskManagementService.updateTask(taskManagementDto, taskId);
        return ResponseEntity.ok(updatedTask);
    }


    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTask(@PathVariable("id") Long taskId) {
        taskManagementService.deleteTask(taskId);
        return ResponseEntity.ok("Task deleted successfully!.");
    }


    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @PatchMapping("{id}/complete")
    public ResponseEntity<TaskManagementDto> completeTask(@PathVariable("id") Long taskId) {
        TaskManagementDto updatedTask = taskManagementService.completeTask(taskId);
        return ResponseEntity.ok(updatedTask);
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @PatchMapping("{id}/in_complete")
    public ResponseEntity<TaskManagementDto> inCompleteTask(@PathVariable("id") Long taskId) {
        TaskManagementDto updatedTask = taskManagementService.inCompleteTask(taskId);
        return ResponseEntity.ok(updatedTask);
    }


    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @PatchMapping("{id}/in_progress")
    public ResponseEntity<TaskManagementDto> inProgressTask(@PathVariable("id") Long taskId) {
        TaskManagementDto updatedTask = taskManagementService.inProgressTask(taskId);
        return ResponseEntity.ok(updatedTask);
    }
}
