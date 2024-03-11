package TaskMangement.com.Task.Util;

import TaskMangement.com.Task.DTO.TaskDTO;
import TaskMangement.com.Task.DTO.UserDTO;
import TaskMangement.com.Task.Model.Task;
import TaskMangement.com.Task.Model.User;

public class DTOConverter {

    public static TaskDTO convertToDTO(Task task) {
        TaskDTO dto = new TaskDTO();
        dto.setId(task.getId());
        dto.setTitle(task.getTitle());
        dto.setDescription(task.getDescription());
        dto.setDueDate(task.getDueDate());
        dto.setStatus(task.getStatus().toString());

        if (task.getAssignedTo() != null) {
            UserDTO assignedToDTO = new UserDTO();
            assignedToDTO.setId(task.getAssignedTo().getId());
            assignedToDTO.setUsername(task.getAssignedTo().getUsername());
            assignedToDTO.setEmail(task.getAssignedTo().getEmail());
            dto.setAssignedTo(assignedToDTO);
        }
        return dto;
    }

    public static User convertToUser(UserDTO userDTO) {
        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setId(userDTO.getId());
        user.setRoles(userDTO.getRoles());
        user.setUsername(userDTO.getUsername());

        return user;
    }
}
