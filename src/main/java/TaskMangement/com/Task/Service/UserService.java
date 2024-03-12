package TaskMangement.com.Task.Service;

import TaskMangement.com.Task.DTO.UserDTO;
import TaskMangement.com.Task.Model.User;

public interface UserService {
    User register(UserDTO userDTO);
    User findById(Long id);
    User update(Long id, UserDTO userDTO);
    void delete(Long id);
}
