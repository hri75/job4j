package ru.job4j.list;

/**
 * Пример односвязанного списка.
 * @param <E>
 */
public class SimpleArrayList<E> {

    /**
     * Размер списка.
     */
    private int size;

    /**
     * Первый узел списка.
     */
    private Node<E> first;

    /**
     * Добавление в начало(!) списка.
     */
    public void add(E data) {
        Node<E> newLink = new Node<>(data);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
    }

    /**
     * Метод удаляет первый элемент в списке.
     * @return - возвращает данные, которые хранились в удаляемом элементе.
     * Если список пуст - метод падает с исключением NullPointerException.
     */
    public E delete() {
        E result = this.first.data;
        this.first = this.first.next;
        this.size--;
        return result;
    }

    /**
     * Метод получения элемента по индексу.
     */
    public E get(int index) {
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.data;
    }

    /**
     *  Метод получения размера коллекции.
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Класс для хранения данных.
     * @param <E> - обобщение - тип, который будет храниться в списке.
     */
    private static class Node<E> {
        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
        }
    }
}
