package ru.job4j.search;

/**
 * Задача.
 */
public class Task {
    /**
     * Описание задачи.
     */
    private String desc;

    /**
     * Приоритет задачи.
     */
    private int priority;

    public Task(String desc, int priority) {
        this.desc = desc;
        this.priority = priority;
    }

    public String getDesc() {
        return desc;
    }

    public int getPriority() {
        return priority;
    }
}
