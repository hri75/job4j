package ru.job4j.tree;

import java.util.Optional;
/**
 * @author Rustam Harisov <hri75@mail.ru>
 * @since 29.05.2018
 */
public interface SimpleTree<E extends Comparable<E>> extends Iterable<E> {
    /**
     * Добавить элемент child в parent.
     * Parent может иметь список child.
     * @param parent parent.
     * @param child child.
     * @return - Истина, если элемент добавлен в дерево.
     */
    boolean add(E parent, E child);

    Optional<Node<E>> findBy(E value);
}
