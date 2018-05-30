package ru.job4j.tree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

/**
 * 1. Создать элементарную структуру дерева [#1711].
 * @author Rustam Harisov <hri75@mail.ru>
 * @since 29.05.2018
 */

/**
 * Дерево.
 * @param <E> - тип значения, хранящегося в узле дерева.
 */
public class Tree<E extends Comparable<E>> implements SimpleTree<E> {

    /**
     * Начальный узел - "корень" дерева.
     */
    private Node<E> root;

    /**
     * Конструктор для дерева.
     * @param value - начальное значение, помещаемое в корень root.
     */
    public Tree(E value) {
        this.root = new Node<>(value);
    }

    @Override
    public boolean add(E parent, E child) {
        boolean isAdded = false;
        if (!this.findBy(child).isPresent()) {
            Optional<Node<E>> parentNode = this.findBy(parent);
            if (parentNode.isPresent()) {
                parentNode.get().add(new Node<>(child));
                isAdded = true;
            }
        }
        return isAdded;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            /**
             * Очередь для обхода дерева.
             */
            private Queue<Node<E>> data = getData();

            @Override
            public boolean hasNext() {
                return !data.isEmpty();
            }

            @Override
            public E next() {
                Node<E> el = data.poll();
                data.addAll(el.leaves());
                return el.getValue();
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
