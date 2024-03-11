package TaskMangement.com.Task.Service;

import TaskMangement.com.Task.DTO.UserDTO;
import TaskMangement.com.Task.Model.User;
import TaskMangement.com.Task.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> findById(Long userId) {
        return userRepository.findById(userId);
    }

    public User update(Long id, UserDTO userDTO) {
        //Find the existing user
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

        //Update the user's properties with the values from userDTO
        user.setUsername(userDTO.getUsername());
        user.setId(userDTO.getId());
        user.setRoles(userDTO.getRoles());
        user.setEmail(userDTO.getEmail());

        return userRepository.save(user);
    }

    //Space for additional methods for updating user details, etc
}