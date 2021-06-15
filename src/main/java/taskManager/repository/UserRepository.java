package taskManager.repository;

import taskManager.domain.Task;
import taskManager.domain.User;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

public interface UserRepository {
    boolean saveUser(@NotNull User user) throws Exception;

    Optional<User> getUser(int id) throws Exception;

    List<User> getUsers() throws Exception;
    void deleteUser(int id) throws Exception;
    List<Task>tasks (int id) throws Exception;


}
