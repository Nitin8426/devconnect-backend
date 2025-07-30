package com.devconnect.task.service;

import com.devconnect.task.dto.TaskDTO;
import java.util.List;

public interface TaskService {
    TaskDTO createTask(TaskDTO dto);
    List<TaskDTO> getAllTasks();
    TaskDTO getTaskById(Long id);
    TaskDTO updateTask(Long id, TaskDTO dto);
    void deleteTask(Long id);
}
