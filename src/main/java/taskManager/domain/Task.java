package taskManager.domain;

import java.time.LocalDateTime;

public abstract class Task {
    private String nameTask; //имя задачи
    private String taskContent;//содержание задачи
    private Priority priority;//приоретет задачи
    private Status status;//статус задачи
    private LocalDateTime dateOfCreation;//дата создания
    private LocalDateTime dateOfDelivery;//дата сдачи
    private LocalDateTime dateOfCompletion;//дата выполнения

    public Task(String nameTask, String taskContent, Priority priority, Status status, LocalDateTime dateOfCreation, LocalDateTime dateOfDelivery) {
        this.nameTask = nameTask;
        this.taskContent = taskContent;
        this.priority = priority;
        this.status = status;
        this.dateOfCreation = dateOfCreation;
        this.dateOfDelivery = dateOfDelivery;
    }

    public String getNameTask() {
        return nameTask;
    }

    public void setNameTask(String nameTask) {
        this.nameTask = nameTask;
    }

    public String getTaskContent() {
        return taskContent;
    }

    public void setTaskContent(String taskContent) {
        this.taskContent = taskContent;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(LocalDateTime dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public LocalDateTime getDateOfDelivery() {
        return dateOfDelivery;
    }

    public void setDateOfDelivery(LocalDateTime dateOfDelivery) {
        this.dateOfDelivery = dateOfDelivery;
    }

    public LocalDateTime getDateOfCompletion() {
        return dateOfCompletion;
    }

    public void setDateOfCompletion(LocalDateTime dateOfCompletion) {
        this.dateOfCompletion = dateOfCompletion;
    }

    @Override
    public String toString() {
        return "Task{" +
                "nameTask='" + nameTask + '\'' +
                ", taskContent='" + taskContent + '\'' +
                ", priority=" + priority +
                ", status=" + status +
                ", dateOfCreation=" + dateOfCreation +
                ", dateOfDelivery=" + dateOfDelivery +
                ", dateOfCompletion=" + dateOfCompletion +
                '}';
    }
}
