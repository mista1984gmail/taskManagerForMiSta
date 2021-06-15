package taskManager.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

public abstract class Task implements Comparable, Serializable {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        if (nameTask != null ? !nameTask.equals(task.nameTask) : task.nameTask != null) return false;
        if (taskContent != null ? !taskContent.equals(task.taskContent) : task.taskContent != null) return false;
        if (priority != task.priority) return false;
        if (status != task.status) return false;
        if (dateOfCreation != null ? !dateOfCreation.equals(task.dateOfCreation) : task.dateOfCreation != null)
            return false;
        if (dateOfDelivery != null ? !dateOfDelivery.equals(task.dateOfDelivery) : task.dateOfDelivery != null)
            return false;
        return dateOfCompletion != null ? dateOfCompletion.equals(task.dateOfCompletion) : task.dateOfCompletion == null;
    }

    @Override
    public int hashCode() {
        int result = nameTask != null ? nameTask.hashCode() : 0;
        result = 31 * result + (taskContent != null ? taskContent.hashCode() : 0);
        result = 31 * result + (priority != null ? priority.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (dateOfCreation != null ? dateOfCreation.hashCode() : 0);
        result = 31 * result + (dateOfDelivery != null ? dateOfDelivery.hashCode() : 0);
        result = 31 * result + (dateOfCompletion != null ? dateOfCompletion.hashCode() : 0);
        return result;
    }
}
