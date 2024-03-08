package TaskMangement.com.Task.Service;

import TaskMangement.com.Task.DTO.TaskDTO;
import TaskMangement.com.Task.DTO.UserDTO;
import TaskMangement.com.Task.Enum.TaskStatus;
import TaskMangement.com.Task.Model.Task;
import TaskMangement.com.Task.Model.User;
import TaskMangement.com.Task.Repository.TaskRepository;
import TaskMangement.com.Task.Repository.UserRepository;
import TaskMangement.com.Task.Util.DTOConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Optional<Task> updateTaskStatus(Long taskId, TaskStatus status) {
        Optional<Task> task = taskRepository.findById(taskId);
        task.ifPresent(t -> {
            t.setStatus(status);
            taskRepository.save(t);
        });
        return task;
    }

    public void deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);
    }

    public List<Task> getTasksByUserId(Long userId) {
        return taskRepository.findByAssignedTo_Id(userId);
    }

    public List<TaskDTO> findAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        return tasks.stream()
                .map(DTOConverter::convertToDTO).collect(Collectors.toList());
    }

    public Task createOrUpdateTask(TaskDTO taskDTO) {
        Task task;
        if (taskDTO.getId() != null) {
            task = taskRepository.findById(taskDTO.getId()).orElseThrow(() -> new RuntimeException("User not found"));
        } else {
            task = new Task();
        }
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setDueDate(taskDTO.getDueDate());
        task.setStatus(TaskStatus.valueOf(taskDTO.getStatus()));
        task.setAssignedTo(resolveUser(taskDTO.getAssignedTo()));
        return taskRepository.save(task);
    }

    private User resolveUser(UserDTO userDTO) {
        if (userDTO != null && userDTO.getId() != null) {
            return userRepository.findById(userDTO.getId())
                    .orElseThrow(() -> new RuntimeException("User not found"));
        }
        return null;
    }
    //Additional methods if needed
}