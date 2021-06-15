package taskManager.domain;

import java.io.Serializable;

public enum Priority implements Serializable {
    HIGH(1,"high"),MIDDLE(2,"middle"),LOW(3,"low");
    public int i;
    public String name;

    Priority(int i) {
        this.i = i;
    }

    Priority(int i, String name) {
        this.i = i;
        this.name = name;
    }

    public void setI(int i) {
        this.i = i;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getI() {
        return i;
    }

    public String getName() {
        return name;
    }

}
