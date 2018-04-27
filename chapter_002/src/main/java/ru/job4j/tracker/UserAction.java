package ru.job4j.tracker;

/**
 * Действия.
 */
public interface UserAction {
    /**
     * Номер действия (начинается с нуля).
     * @return - номер действия (с 0 до 6).
     */
    int key();

    /**
     * Выполняемое действие.
     * @param input - входная информация.
     * @param tracker - хранилище заявок.
     */
    void execute(Input input, Tracker tracker);

    /**
     * Информация - что делает данный метод.
     * @return - строка, обозначающая меню.
     */
    String info();

}
