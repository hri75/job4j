package ru.job4j.tree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 3. Собственная реализация Binary search tree [#1714].
 * @author Rustam Harisov <hri75@mail.ru>
 * @since 30.05.2018
 */
public class BinarySearchTree<E extends Comparable<E>> implements Iterable<E> {

    /**
     * Узел. Из узлов состоит дерево.
     * @param <E> тип значения, хранимого в узле.
     */
    private class Node<E extends Comparable<E>> {
        /**
         * Значение, хранимое в узле.
         */
        private E value;
        /**
         * Левая ветка.
         */
        private Node<E> left;
        /**
         * Правая ветка.
         */
        private Node<E> right;

        /**
         * Конструктор для класса Node.
         * @param value - значение, хранимое в узле.
         */
        private Node(E value) {
            this.value = value;
        }

        /**
         * Метод добавляет дочерний узел.
         * Добавит в левую ветку, если значение в добавляемом узле меньше или равно значения в текущем узле.
         * Иначе добавит в правую ветку.
         * Если ветка, куда добавляется значение, занята, надо найти такой дочерний элемент,
         * у которого будет свободна соответствующая ветка, и добавить туда.
         * @param child - добавляемый узел.
         */
        private void add(Node<E> child) {
            if (this.value.compareTo(child.value) >= 0) {
                if (this.left == null) {
                    this.left = child;
                } else {
                    this.left.add(child);
                }
            } else {
                if (this.right == null) {
                    this.right = child;
                } else {
                    this.right.add(child);
                }
            }
        }
    }

    /**
     * Корень дерева.
     */
    private Node<E> root;

    /**
     * Конструктор дерева.
     * @param value - значение, которое будет в начальном узле дерева (в корне).
     */
    public BinarySearchTree(E value) {
        this.root = new Node<>(value);
    }

    /**
     * Метод добавляет в дерево значение.
     * @param value - добавляемое значение.
     */
    public void add(E value) {
        this.root.add(new Node<>(value));
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            /**
             * Очередь для обхода дерева.
             */
            Queue<Node<E>> data = getData();

            @Override
            public boolean hasNext() {
                return (!data.isEmpty());
            }

            @Override
            public E next() {
                Node<E> element = data.poll();
                if (element.left != null) {
                    data.offer(element.left);
                }
                if (element.right != null) {
                    data.offer(element.right);
                }
                return element.value;
            }

            /**
             * Возвращает очередь с одним элементом root.
             * Очередь нужна для обхода дерева.
             * @return - очередь.
             */
            private Queue<Node<E>> getData() {
                Queue<Node<E>> data = new LinkedList<>();
                data.offer(root);
                return data;
            }
        };
    }
}
