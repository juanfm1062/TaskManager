package TaskMangement.com.Task.DTO;

import TaskMangement.com.Task.Model.User;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class TaskDTO {

    private Long id;

    @NotNull(message = "{task.title.notblank}")
    private String title;
    private String description;

    @NotNull(message = "{task.duedate.future}")
    @Future(message = "{task.duedate.future}")
    private LocalDateTime dueDate;
    private String status;
    private User assignedTo;

    public TaskDTO(Long id, String title, String description, LocalDateTime dueDate, String status, User assignedTo) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.status = status;
        this.assignedTo = assignedTo;
    }

    public TaskDTO() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(User assignedTo) {
        this.assignedTo = assignedTo;
    }
}