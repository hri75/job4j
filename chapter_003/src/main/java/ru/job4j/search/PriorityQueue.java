package ru.job4j.search;

import java.util.LinkedList;

/**
 * Очередь c приоритетом.
 */
public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставки использовать add(int index, E value)
     * @param task задача
     */
    public void put(Task task) {
        if (tasks.size() < task.getPriority()) {
            tasks.add(task);
        } else {
            tasks.add(task.getPriority() - 1, task);
        }
    }

    public Task take() {
        return this.tasks.poll();
    }
}
