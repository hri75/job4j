package ru.job4j.tracker;

/**
 * Абстрактный класс BaseAction - реализует часть функций интерфейса UserAction.
 */
public abstract class BaseAction implements UserAction {
    private final int key;
    private final String name;

    /**
     * Конструктор.
     * @param key - номер пункта меню.
     * @param name - наименвоание пункта меню.
     */
    protected BaseAction(final int key, final String name) {
        this.key = key;
        this.name = name;
    }

    /**
     * Вернуть номер пункта меню данного действия.
     * @return - числовой номер пункта меню (начинается с 0).
     */
    @Override
    public int key() {
        return this.key;
    }

    /**
     * Наименование пункта меню.
     * @return - строка
     */
    @Override
    public String info() {
        return String.format("%s. %s", this.key, this.name);
    }
}
