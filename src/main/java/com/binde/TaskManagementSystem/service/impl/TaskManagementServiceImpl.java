package com.binde.TaskManagementSystem.service.impl;

import com.binde.TaskManagementSystem.dto.TaskManagementDto;
import com.binde.TaskManagementSystem.entity.TaskManagement;
import com.binde.TaskManagementSystem.exception.ResourceNotFoundException;
import com.binde.TaskManagementSystem.repository.TaskManagementRepository;
import com.binde.TaskManagementSystem.service.TaskManagementService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TaskManagementServiceImpl implements TaskManagementService {
    private TaskManagementRepository taskManagementRepository;
    private ModelMapper modelMapper;

    @Override
    public TaskManagementDto createTask(TaskManagementDto taskManagementDto) {

        TaskManagement task = modelMapper.map(taskManagementDto, TaskManagement.class);

        TaskManagement savedTaskManagement = taskManagementRepository.save(task);


        TaskManagementDto savedTaskManagementDto = modelMapper.map(savedTaskManagement, TaskManagementDto.class);

        return savedTaskManagementDto;

    }

    @Override
    public TaskManagementDto getTodo(Long id) {
        TaskManagement taskManagement = taskManagementRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found with id:" + id));

        return modelMapper.map(taskManagement, TaskManagementDto.class);
    }

    @Override
    public List<TaskManagementDto> getAllTasks() {
        List<TaskManagement> tasks = taskManagementRepository.findAll();

        return tasks.stream().map((taskManagement) -> modelMapper.map(taskManagement, TaskManagementDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public TaskManagementDto updateTask(TaskManagementDto taskManagementDto, Long id) {
        TaskManagement task = taskManagementRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id : " + id));
        task.setTitle(taskManagementDto.getTitle());
        task.setDescription(taskManagementDto.getDescription());
        task.setCompleted(taskManagementDto.isCompleted());

        TaskManagement updatedTask = taskManagementRepository.save(task);

        return modelMapper.map(updatedTask, TaskManagementDto.class);
    }

    @Override
    public void deleteTask(Long id) {
        TaskManagement taskManagement = taskManagementRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id : " + id));

        taskManagementRepository.deleteById(id);
    }

    @Override
    public TaskManagementDto completeTask(Long id) {
        TaskManagement task = taskManagementRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id : " + id));

        task.setCompleted(Boolean.TRUE);

        TaskManagement updatedTask = taskManagementRepository.save(task);

        return modelMapper.map(updatedTask, TaskManagementDto.class);
    }

    @Override
    public TaskManagementDto inCompleteTask(Long id) {
        TaskManagement task = taskManagementRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id : " + id));

        task.setCompleted(Boolean.FALSE);

        TaskManagement updatedTask = taskManagementRepository.save(task);

        return modelMapper.map(updatedTask, TaskManagementDto.class);

    }

    @Override
    public TaskManagementDto inProgressTask(Long id) {
        TaskManagement task = taskManagementRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id : " + id));

        task.setCompleted(Boolean.FALSE);

        TaskManagement updatedTask = taskManagementRepository.save(task);

        return modelMapper.map(updatedTask, TaskManagementDto.class);
    }
}
