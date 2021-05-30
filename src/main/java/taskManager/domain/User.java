package taskManager.domain;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class User {
    String nameUser;
    int id;
    List<Task> taskList;


    public void addTask(List<Task> list,Task task){ //добавление задач
        list.add(task);
    }


    public void sortByPriority(List<Task>taskList){ //сортировка по приоритету
        Collections.sort(taskList, new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                if(o1.getPriority().getI() > o2.getPriority().getI()){
                    return 1;
                }
                else if (o1.getPriority().getI()<o2.getPriority().getI()){
                    return -1;
                }
                else {
                    return 0;
                }
            }
        });
    }
    public void sortByName(List<Task>taskList){ //сортировка по имени
        Collections.sort(taskList, new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                return o1.getNameTask().compareTo(o2.getNameTask());
            }
        });
    }



    public User(String nameUser, int id, List<Task> taskList) {
        this.nameUser = nameUser;
        this.id = id;
        this.taskList = taskList;
    }

    public User(String nameUser) {
        this.nameUser = nameUser;
    }

    public User(int id) {
        this.id = id;
    }

    public User(String nameUser, int id) {
        this.nameUser = nameUser;
        this.id = id;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

    @Override
    public String toString() {
        return "User{" +
                "nameUser='" + nameUser + '\'' +
                ", id=" + id +
                ", taskList=" + taskList +
                '}';
    }
}
