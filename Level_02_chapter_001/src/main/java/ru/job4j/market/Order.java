package ru.job4j.market;

/**
 * задача "Биржевой стакан. [#1001]".
 *
 * @author Rustam Harisov <hri75@mail.ru>
 * @since 31.05.2018
 */

import java.util.UUID;

/**
 * Заявка.
 */
public class Order implements Comparable<Order> {
    /**
     * уникальный ключ заявки.
     */
    private UUID id;

    /**
     * идентификатор ценной бумаги.
     */
    private Book book;

    /**
     * Тип заявки - add/delete - выставить заявку на торги или снять.
     */
    private Type type;

    /**
     * action - bid/ask - заявка имеет два действия. Заявка на покупку ценной бумаги или на продажу.
     */
    private Action action;

    /**
     * Цена, по которой мы ходим сделать действия покупки или продажи.
     *
     * Примечание: сделал тип int, так как использовать BigDecimal пока знаний не хватает,
     * а хранить деньги в float и double - по моему мнению, нельзя, из-за ошибок округления.
     */
    private int price;

    /**
     * Количество акций, которые мы хотим продать или купить.
     */
    private int volume;

    /**
     * Конструктор для заявки.
     *
     * @param book - ценная бумага.
     * @param type - тип заявки (ADD/DELETE)
     * @param action - действие по заявке (bid/ask).
     * @param price - цена ценной бумаги.
     * @param volume - количество ценных бумаг.
     */
    public Order(Book book, Type type, Action action, int price, int volume) {
        this.id = UUID.randomUUID();
        this.book = book;
        this.type = type;
        this.action = action;
        this.price = price;
        this.volume = volume;
        if (price <= 0) {
            throw new IllegalArgumentException("The price can not be equal to or less than 0!");
        }
        if (volume <= 0) {
            throw new IllegalArgumentException("The volume can not be equal to or less than 0!");
        }
        if (action == null) {
            throw new IllegalArgumentException("The action can not be null!");
        }
        if (type == null) {
            throw new IllegalArgumentException("The type can not be null!");
        }
        if (book == null) {
            throw new IllegalArgumentException("The book can not be null!");
        }
    }

    public UUID getId() {
        return id;
    }

    public Book getBook() {
        return book;
    }

    public Type getType() {
        return type;
    }

    public Action getAction() {
        return action;
    }

    public int getPrice() {
        return price;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public int compareTo(Order o) {
        int result = Integer.compare(this.price, o.price);
        if (result == 0) {
            result = this.id.toString().compareTo(o.id.toString());
        }
        return result;
    }
}
