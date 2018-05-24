package ru.job4j.set;

import ru.job4j.list.DynamicArrayList;

import java.util.Iterator;

/**
 * Коллекция Set на массиве.
 * @param <T> - тип хранимых в коллекции значений.
 */
public class SimpleSet<T> implements Iterable<T> {

    /**
     * Внутреннее хранилище.
     */
    private DynamicArrayList<T> container = new DynamicArrayList<>();

    /**
     * Метод, добавляющий в SimpleSet только уникальные значения.
     * @param value - добавляемое значение.
     */
    public void add(T value) {
        boolean isAllowed = true;
        for (int i = 0; i < this.container.size(); i++) {
            if (value == null ? this.container.get(i) == null : value.equals(this.container.get(i))) {
                isAllowed = false;
                break;
            }
        }
        if (isAllowed) {
            this.container.add(value);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return this.container.iterator();
    }
}
