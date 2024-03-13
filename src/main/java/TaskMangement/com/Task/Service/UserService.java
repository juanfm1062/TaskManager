package TaskMangement.com.Task.Service;

import TaskMangement.com.Task.DTO.UserDTO;
import TaskMangement.com.Task.Model.User;
import org.springframework.security.access.prepost.PreAuthorize;

public interface UserService {
    User register(UserDTO userDTO);
    User findById(Long id);
    @PreAuthorize("hasRole('ROLE_ADMIN') or @userSecurityService.isSelfOrAdmin(#userId)")
    User update(Long id, UserDTO userDTO);
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    void delete(Long id);
}
