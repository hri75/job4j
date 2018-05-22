package ru.job4j.generic;

import java.util.Iterator;

/**
 * Универсальная обертка над массивом.
 * @param <T>
 */
public class SimpleArray<T> implements Iterable<T> {

    private Object[] array;
    private int position = 0;

    public SimpleArray(int capacity) {
        this.array = new Object[capacity];
    }

    /**
     * Метод добавляет значение в массив.
     * @param model - добавляемое значение.
     */
    public void add(T model) {
        if (this.position < this.array.length) {
            this.array[this.position++] = model;
        } else {
            throw new RuntimeException("Переполнение.");
        }
    }

    /**
     * Метод заменяет значение по указанному индексу на переданное значение.
     * @param index - индекс, по которому надо произвести замену.
     * @param model - значение.
     */
    public void set(int index, T model) {
        if (index < 0 || index >= position) {
            throw new IndexOutOfBoundsException();
        }
        this.array[index] = model;
    }

    /**
     * Метод возвращает значение по указанному индексу.
     * @param index - индекс
     * @return - значение.
     */
    public T get(int index) {
        if (index < 0 || index >= position) {
            throw new IndexOutOfBoundsException();
        }
        return (T) array[index];
    }

    /**
     * Метод удаляет элемент по указанному индексу.
     * @param index - индекс.
     */
    public void delete(int index) {
        if (index < 0 || index >= position) {
            throw new IndexOutOfBoundsException();
        }
        System.arraycopy(this.array, index + 1, this.array, index, position - index - 1);
        position--;
    }

    /**
     * Метод возвращает итератор.
     * @return - итератор.
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int pointer = 0;

            @Override
            public boolean hasNext() {
                return this.pointer < position;
            }

            @Override
            public T next() {
                return (T) array[pointer++];
            }
        };
    }
}
