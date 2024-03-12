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
public class TaskServiceImpl implements TaskService{
    private final TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task createTask(TaskDTO taskDTO) {
        Task task = new Task();
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setStatus(TaskStatus.valueOf(taskDTO.getStatus()));
        task.setDueDate(taskDTO.getDueDate());
        task.setAssignedTo(taskDTO.getAssignedTo());

        return taskRepository.save(task);
    }

    @Override
    public Task updateTask(Long id, TaskDTO taskDTO) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setStatus(TaskStatus.valueOf(taskDTO.getStatus()));
        task.setDueDate(taskDTO.getDueDate());
        task.setAssignedTo(taskDTO.getAssignedTo());

        return taskRepository.save(task);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task getTaskById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found.");
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}