package taskManager.domain;

import java.time.LocalDateTime;

public class RepeatableTask extends Task{
    private String periodicity;//периодичность задачи

    public RepeatableTask(String nameTask, String taskContent, Priority priority, Status status, LocalDateTime dateOfCreation, LocalDateTime dateOfDelivery, String periodicity) {
        super(nameTask, taskContent, priority, status, dateOfCreation, dateOfDelivery);
        this.periodicity = periodicity;
    }


    @Override
    public String toString() {
        return "RepeatableTask{" +super.toString()+
                ", periodicity='" + periodicity + '\'' +
                "} ";
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
