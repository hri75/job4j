package ru.job4j.list;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 * Динамический список на базе массива.
 * @param <E> - тип.
 */
public class DynamicArrayList<E> implements Iterable<E> {

    private static final int DEFAULT_CAPACITY = 2;
    private Object[] container;
    private int index = 0;

    /**
     * Счетчик изменений - для  fail-fast поведения итератора.
     */
    private int modCount = 0;

    /**
     * Конструктор по умолчанию.
     */
    public DynamicArrayList() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Конструктор с заданной емкостью контейнера.
     * @param capacity - начальная емкость контейнера.
     */
    public DynamicArrayList(int capacity) {
        if (capacity > 0) {
            this.container = new Object[capacity];
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + capacity);
        }
    }

    public void add(E value) {
        modCount++;
        if (this.index >= this.container.length) {
            Object[] temp = this.container;
            this.container = new Object[this.index + DEFAULT_CAPACITY];
            System.arraycopy(temp, 0, this.container, 0, this.index);
        }
        this.container[this.index++] = value;
    }

    public E get(int index) {
        if (index < 0 || index >= this.index) {
            throw new IndexOutOfBoundsException();
        }
        return (E) container[index];
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int pointer = 0;
            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                checkModCount();
                return pointer < index;
            }

            @Override
            public E next() {
                checkModCount();
                return (E) container[pointer++];
            }

            private void checkModCount() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
            }
        };
    }
}
