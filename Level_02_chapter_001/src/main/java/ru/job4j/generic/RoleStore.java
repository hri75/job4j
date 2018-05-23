package ru.job4j.generic;

/**
 * Класс-хранилище для класса Role.
 *
 * Так как все переехало в класс AbstractStore, здесь почти ничего и не осталось.
 */
public class RoleStore extends AbstractStore<Role> implements Store<Role> {
    /**
     * Конструктор.
     * @param capacity - количество элементов, которое можно хранить в данном контейнере.
     */
    public RoleStore(int capacity) {
        super(capacity);
    }
}