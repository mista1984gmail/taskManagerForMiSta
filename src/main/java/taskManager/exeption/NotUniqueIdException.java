package taskManager.exeption;

import taskManager.domain.User;

public class NotUniqueIdException extends Exception{
    public NotUniqueIdException(User user) {
        super("User is not saved: " + user);
    }
}
