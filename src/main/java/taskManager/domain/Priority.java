package taskManager.domain;

public enum Priority {
    HIGH(1,"high"),MIDDLE(2,"middle"),LOW(3,"low");
    private int i;
    private String name;

    Priority(int i, String name) {
        this.i = i;
        this.name = name;
    }

    public int getI() {
        return i;
    }

    public String getName() {
        return name;
    }

}
