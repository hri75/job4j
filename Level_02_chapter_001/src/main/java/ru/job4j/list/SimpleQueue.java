package ru.job4j.list;

/**
 * Контейнер Queue.
 * @param <T> - тип хранимых в очереди значений.
 */
public class SimpleQueue<T> {

    private DynamicArrayList<T> container = new DynamicArrayList<>();

    public void push(T value) {
        this.container.add(value);
    }

    public T poll() {
        return this.container.remove(0);
    }
}
