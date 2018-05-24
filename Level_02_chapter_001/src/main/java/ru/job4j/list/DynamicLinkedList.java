package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 * Динамический контейнер на базе связанного списка.
 * @param <E> - тип хранимых в контейнере значений.
 */
public class DynamicLinkedList<E> implements Iterable<E> {
    private Node<E> first;
    private int modCount = 0;

    /**
     * Метод добавит элемент в конец списка.
     * @param value - значение добавляемого элемента.
     */
    public void add(E value) {
        modCount++;
        Node<E> newElement = new Node<>(value);
        if (first == null) {
            first = newElement;
        } else {
            Node<E> lastElement = first;
            while (lastElement.next != null) {
                lastElement = lastElement.next;
            }
            lastElement.next = newElement;
        }
    }

    /**
     * Метод вернет значение элемента по указанному индексу.
     * @param index - указанный индекс.
     * @return - значение элемента (типа <E>).
     */
    public E get(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Iterator<E> iterator = this.iterator();
        E result = null;
        for (int i = 0; i <= index; i++) {
            try {
                result = iterator.next();
            } catch (NullPointerException ex) {
                throw new IndexOutOfBoundsException();
            }
        }
        return result;
    }

    /**
     * Итератор.
     * @return - итератор с типом возвращаемого значения <E>.
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            /**
             * Текущий элемент итератора.
             */
            private Node<E> currentElement = first;
            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                checkModCount();
                return (this.currentElement != null);
            }

            @Override
            public E next() {
                checkModCount();
                E result = this.currentElement.data;
                this.currentElement = this.currentElement.next;
                return result;
            }

            private void checkModCount() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
            }
        };
    }

    /**
     * Класс для хранения элементов списка.
     * @param <E> - данные, хранимые в элементе списка.
     */
    private static class Node<E> {
        private E data;
        /**
         * Сcылка на следующий элемент списка.
         */
        private Node<E> next;

        private Node(E data) {
            this.data = data;
        }
    }
}
