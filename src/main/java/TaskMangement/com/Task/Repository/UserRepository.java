package TaskMangement.com.Task.Repository;

import TaskMangement.com.Task.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}