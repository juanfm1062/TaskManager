package TaskMangement.com.Task.Service;

import TaskMangement.com.Task.DTO.TaskDTO;
import TaskMangement.com.Task.Model.Task;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

public interface TaskService {
    Task createTask(TaskDTO taskDTO);
    @PreAuthorize("hasRole('ROLE_ADMIN') or @taskSecurityService.isOwner(#id, authentication.name)")
    Task updateTask(Long id, TaskDTO taskDTO);
    List<Task> getAllTasks();
    Task getTaskById(Long id);
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    void deleteTask(Long id);
}
