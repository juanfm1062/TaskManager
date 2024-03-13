package TaskMangement.com.Task.Security;

import TaskMangement.com.Task.Model.Task;
import TaskMangement.com.Task.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("taskSecurityService")
public class TaskSecurityService {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskSecurityService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public boolean isOwner(Long taskId, String username) {
        return taskRepository.findById(taskId)
                .map(Task::getAssignedTo)
                .filter(user -> user.getUsername().equals(username))
                .isPresent();
    }
}
