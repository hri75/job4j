package ru.job4j.list;

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
        checkContainerSize();
        this.container[this.index++] = value;
    }

    public E get(int index) {
        if (index < 0 || index >= this.index) {
            throw new IndexOutOfBoundsException();
        }
        return (E) container[index];
    }

    /**
     * Метод возвращает количество элементов в контейнере.
     * @return - количество элементов в контейнере.
     */
    public int size() {
        return this.index;
    }

    /**
     * Метод добавляет элемент в контейнер по указанному индексу.
     * @param index - индекс.
     * @param value - добавляемое значение.
     */
    public void add(int index, E value) {
        modCount++;
        if (index < 0 || index > this.index) {
            throw new IndexOutOfBoundsException();
        }
        checkContainerSize();
        System.arraycopy(this.container, index, this.container, index + 1, this.index - index);
        this.container[index] = value;
        this.index++;
    }

    /**
     * Метод удаляет из контейнера элемент по указанному индексу. Возвращает элемент, который был удален из контейнера.
     * @param index - индекс, по которому удалить элемент.
     * @return - элемент, который удален.
     *
     * Примечание: если индекс, по которому надо удалить элемент, указывает на последний элемент - тогда туда запишем null,
     * тем самым освободим ссылку на элемент, чтобы GarbageCollector мог выполнить свою работу.
     */
    public E remove(int index) {
        modCount++;
        if (index < 0 || index >= this.index) {
            throw new IndexOutOfBoundsException();
        }
        E result = (E) this.container[index];
        if (index == this.index - 1) {
            this.container[--this.index] = null;
        } else {
            System.arraycopy(this.container, index + 1, this.container, index, this.index - index - 1);
            this.index--;
        }
        return result;
    }

    /**
     * Метод проверяет размер контейнера, и если размер недостаточен, увеличивает размер контейнера на DEFAULT_CAPACITY.
     */
    private void checkContainerSize() {
        if (this.index >= this.container.length) {
            Object[] temp = this.container;
            this.container = new Object[this.index + DEFAULT_CAPACITY];
            System.arraycopy(temp, 0, this.container, 0, this.index);
        }
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
