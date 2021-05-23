package taskManager.domain;

import java.time.LocalDateTime;

public class OneTimeTask extends Task {


    public OneTimeTask(String nameTask, String taskContent, Priority priority, Status status, LocalDateTime dateOfCreation, LocalDateTime dateOfDelivery) {
        super(nameTask, taskContent, priority, status, dateOfCreation, dateOfDelivery);
    }
}
