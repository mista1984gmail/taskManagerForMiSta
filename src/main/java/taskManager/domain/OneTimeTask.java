package taskManager.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

public class OneTimeTask extends Task implements Serializable {

    public OneTimeTask(String nameTask, String taskContent, Priority priority, Status status, LocalDateTime dateOfCreation, LocalDateTime dateOfDelivery) {
        super(nameTask, taskContent, priority, status, dateOfCreation, dateOfDelivery);
    }


    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
