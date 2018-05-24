package ru.job4j.set;

import java.util.Iterator;

/**
 * Set реализованный на связном списке.
 * @param <T> - тип хранимых в коллекции значений.
 */
public class SimpleLinkedSet<T> implements Iterable<T> {

    private Node<T> first;

    public void add(T value) {
        Node<T> newElement = new Node<>(value);
        if (first == null) {
            first = newElement;
        } else {
            boolean isAllowed = true;
            Iterator<T> iterator = this.iterator();
            while (iterator.hasNext()) {
                if (value == null ? iterator.next() == null : value.equals(iterator.next())) {
                    isAllowed = false;
                    break;
                }
            }
            if (isAllowed) {
                newElement.next = first;
                first = newElement;
            }
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> currentElement = first;

            @Override
            public boolean hasNext() {
                return (currentElement != null);
            }

            @Override
            public T next() {
                T result = currentElement.value;
                currentElement = currentElement.next;
                return result;
            }
        };
    }

    /**
     * Узел для хранения данных.
     * @param <T>
     */
    private static class Node<T> {
        /**
         * Данные, хранимые в узле.
         */
        private T value;

        /**
         * Ссылка на следующий элемент списка.
         */
        private Node<T> next;

        private Node(T value) {
            this.value = value;
        }
    }
}
