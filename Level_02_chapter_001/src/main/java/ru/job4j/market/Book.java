package ru.job4j.market;

/**
 * задача "Биржевой стакан. [#1001]".
 *
 * @author Rustam Harisov <hri75@mail.ru>
 * @since 31.05.2018
 */

/**
 * Ценная бумага (акция).
 */
public class Book {
    /**
     * Название ценной бумаги.
     */
    private String name;

    public String getName() {
        return name;
    }

    public Book(String name) {
        this.name = name;
    }
}
