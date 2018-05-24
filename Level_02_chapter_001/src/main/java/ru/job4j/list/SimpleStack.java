package ru.job4j.list;

/**
 * Контейнер Stack.
 * @param <T> - тип хранимых в стеке значений.
 */
public class SimpleStack<T> {

    private DynamicArrayList<T> container = new DynamicArrayList<>();

    public T poll() {
        return this.container.remove(0);
    }

    public void push(T value) {
        this.container.add(0, value);
    }
}
