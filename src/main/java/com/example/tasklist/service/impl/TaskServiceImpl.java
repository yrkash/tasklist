package com.example.tasklist.service.impl;

import com.example.tasklist.domain.exception.ResourceMappingException;
import com.example.tasklist.domain.task.Status;
import com.example.tasklist.domain.task.Task;
import com.example.tasklist.repository.TaskRepository;
import com.example.tasklist.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Override
    @Transactional(readOnly = true)
    public com.example.tasklist.domain.task.Task getById(Long id) {

        return taskRepository.findById(id)
                .orElseThrow(() -> new ResourceMappingException("Task not found."));
    }

    @Override
    @Transactional(readOnly = true)
    public List<com.example.tasklist.domain.task.Task> getAllByUserId(Long id) {

        return taskRepository.findAllByUserId(id);
    }

    @Override
    @Transactional
    public Task update(com.example.tasklist.domain.task.Task task) {
        if (task.getStatus() == null) {
            task.setStatus(Status.TODO);
        }
        taskRepository.update(task);
        return task;
    }

    @Override
    @Transactional
    public Task create(Task task, Long userId) {
        task.setStatus(Status.TODO);
        taskRepository.create(task);
        taskRepository.assignToUserById(task.getId(), userId);
        return task;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        taskRepository.delete(id);
    }
}
