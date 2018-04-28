package ru.job4j.tracker;

/**
 * Исключение - наше собственноручно созданное.
 * Возникает, когда пользователь ввел неправильный пункт меню.
 */
public class MenuOutException extends RuntimeException {
    public MenuOutException(String msg) {
        super(msg);
    }
}
