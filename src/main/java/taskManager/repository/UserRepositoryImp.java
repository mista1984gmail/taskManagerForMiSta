package taskManager.repository;

import lombok.extern.slf4j.Slf4j;
import taskManager.db.BD;
import taskManager.domain.Task;
import taskManager.domain.User;
import taskManager.exeption.NotUniqueIdException;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Slf4j
public class UserRepositoryImp implements UserRepository {

    @Override
    public boolean saveUser(@NotNull User user) throws Exception {
        try (BD bd = BD.getInstance()) {
            bd.executeSaveOperation(user);
            return true;
        } catch (NotUniqueIdException e) {
            log.error(e.getMessage());
            return false;
        }
    }

    @Override
    public Optional<User> getUser(int id) throws Exception {
        try (BD bd = BD.getInstance()) {
            return bd.executeGetOperation(id);
        }
    }

    @Override
    public List<User> getUsers() throws Exception {
        try (BD bd = BD.getInstance()) {
            return bd.executeGetAllOperation();
        }
    }
    @Override
    public void deleteUser(int id) throws Exception {
        try (BD bd = BD.getInstance()) {
            bd.executeDeleteOperation(id);
        } catch (NotUniqueIdException e) {
            log.error(e.getMessage());
        }
    }

    @Override
    public List<Task>tasks(int id) throws Exception {
        try (BD bd = BD.getInstance()) {
            return bd.getTaskUser(id);
        }
    }


}

