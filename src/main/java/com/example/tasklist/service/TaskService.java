package com.example.tasklist.service;

import com.example.tasklist.domain.task.Task;

import java.util.List;

public interface TaskService {

    com.example.tasklist.domain.task.Task getById(Long id);
    List<com.example.tasklist.domain.task.Task> getAllByUserId(Long id);
    Task update(Task task);
    Task create(Task task, Long userId);
    void delete(Long id);


}
