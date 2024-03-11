package TaskMangement.com.Task.DTO;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public class CommentDTO {
    private Long id;

    @NotBlank(message = "Comment content cannot be blank")
    private String content;
    private LocalDateTime timestamp;
    private UserDTO user;

    public CommentDTO(Long id, String content, LocalDateTime timestamp, UserDTO user) {
        this.id = id;
        this.content = content;
        this.timestamp = timestamp;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }
}
