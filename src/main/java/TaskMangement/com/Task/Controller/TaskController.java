package TaskMangement.com.Task.Controller;

import TaskMangement.com.Task.DTO.TaskDTO;
import TaskMangement.com.Task.Model.Task;
import TaskMangement.com.Task.Service.TaskService;
import TaskMangement.com.Task.Util.DTOConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/taskmanager/tasks")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        Task createdTask = taskService.createTask(task);
        return ResponseEntity.ok(createdTask);
    }

    @PutMapping("/{taskId}/status")
    public ResponseEntity<Task> updateTaskStatus(@PathVariable Long taskId, Task task) {
        return taskService.updateTaskStatus(taskId, task.getStatus())
                .map(updatedTask -> ResponseEntity.ok(updatedTask))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Task>> getTasksByUserId(@PathVariable Long userId) {
        List<Task> tasks = taskService.getTasksByUserId(userId);
        if (tasks.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<TaskDTO>> getALlTasks() {
        List<TaskDTO> tasks = taskService.findAllTasks();
        return ResponseEntity.ok(tasks);
    }

    @PostMapping
    public ResponseEntity<TaskDTO> createTask(@RequestBody TaskDTO taskDTO) {
        Task task = taskService.createOrUpdateTask(taskDTO);
        TaskDTO createdTaskDTO = DTOConverter.convertToDTO(task);
        return new ResponseEntity<>(createdTaskDTO, HttpStatus.CREATED);
    }
    //Additional endpoints as needed
}