package TaskMangement.com.Task.Service;

import TaskMangement.com.Task.Enum.TaskStatus;
import TaskMangement.com.Task.Model.Task;
import TaskMangement.com.Task.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
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

    //Additional methods if needed
}