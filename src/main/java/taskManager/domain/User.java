package taskManager.domain;

import lombok.*;

import java.io.Serializable;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Builder(access = AccessLevel.PUBLIC)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    String nameUser;
    @NonNull
    int id;
    List<Task> taskList;

/*
    public void sortByPriority(List<Task> taskList) { //сортировка по приоритету
        Collections.sort(taskList, new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                if (o1.getPriority().getI() > o2.getPriority().getI()) {
                    return 1;
                } else if (o1.getPriority().getI() < o2.getPriority().getI()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
    }

    public void sortByName(List<Task> taskList) { //сортировка по имени
        Collections.sort(taskList, new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                return o1.getNameTask().compareTo(o2.getNameTask());
            }
        });
    }

    @Override
    public String toString() {
        return "User{" +
                "nameUser='" + nameUser + '\'' +
                ", id=" + id +
                ", taskList=" + taskList +
                '}';
    }*/


}
