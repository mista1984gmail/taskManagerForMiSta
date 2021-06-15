package taskManager.db;

import taskManager.domain.Task;
import taskManager.domain.User;
import taskManager.exeption.IdIsNotAllowedOnDbException;
import taskManager.exeption.NotUniqueIdException;
import taskManager.io.SerializationUtils;

import java.io.Serializable;
import java.util.*;

public final class BD implements Serializable, AutoCloseable {

    private Map<Integer, User> USERS;
    private static final int MAX_ALLOWED_ID = 100;
    private static BD instance = new BD();
    private int currentId = 0;

    private BD(){
        USERS=new HashMap<>();
    }

    public static BD getInstance() {
        return instance;
    }

    public void executeSaveOperation(User user)
            throws NotUniqueIdException {
        user.setId(currentId);
        if (USERS.containsKey(user.getId())) {
            throw new NotUniqueIdException(user);
        }
        USERS.put(currentId++, user);
    }

    public Optional<User> executeGetOperation(int id) {
        if (id > MAX_ALLOWED_ID) {
            throw new IdIsNotAllowedOnDbException(id);
        }
        return Optional.ofNullable(USERS.get(id));
    }

    public void save() {
        SerializationUtils.serialize(this);
    }


    public void load() {
        Object deserialized = SerializationUtils.deserialize();
        if (deserialized instanceof BD) {
            instance = (BD) deserialized;
        }
    }
    public List<User> executeGetAllOperation() {
        return new ArrayList<>(USERS.values());
    }

    @Override
    public void close() throws Exception {

    }

    public void executeDeleteOperation(int id){
        USERS.remove(id);
        BD.getInstance().save();
    }
    public List<Task> getTaskUser(int id){
        return USERS.get(id).getTaskList();
    }
}
