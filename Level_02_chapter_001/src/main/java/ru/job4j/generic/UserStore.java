package ru.job4j.generic;

/**
 * Класс-хранилище для класса User.
 *
 * Так как все переехало в класс AbstractStore, здесь почти ничего и не осталось.
 */
public class UserStore extends AbstractStore<User> implements Store<User> {
    /**
     * Конструктор.
     * @param capacity - количество элементов, которое можно хранить в данном контейнере.
     */
    public UserStore(int capacity) {
        super(capacity);
    }
}
