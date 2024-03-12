package TaskMangement.com.Task.Service;

import TaskMangement.com.Task.DTO.TaskDTO;
import TaskMangement.com.Task.Model.Task;

import java.util.List;

public interface TaskService {
    Task createTask(TaskDTO taskDTO);
    Task updateTask(Long id, TaskDTO taskDTO);
    List<Task> getAllTasks();
    Task getTaskById(Long id);
    void deleteTask(Long id);
}
