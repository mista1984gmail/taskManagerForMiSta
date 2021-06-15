package taskManager.service;

import taskManager.domain.Task;
import taskManager.domain.User;

import javax.validation.constraints.NotNull;

public interface UserService {
        void saveUser(@NotNull User user) throws Exception;
        User getUser(int id) throws Exception;
        void showShortInfo() throws Exception;
        void deleteUser (int id) throws Exception;
        void showTaskInfo(int id) throws Exception;
        Task addTask() throws Exception;
        void showDeadLineInfo(int id) throws Exception;
        void sortTaskByPriority(int id) throws Exception;
    }

