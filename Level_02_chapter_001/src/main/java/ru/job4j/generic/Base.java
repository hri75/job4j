package ru.job4j.generic;

/**
 * Абстрактный класс Base.
 */
public abstract class Base {
    private final String id;

    /**
     * Конструктор.
     * @param id - строковый идентификатор.
     */
    protected Base(final String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }
}
