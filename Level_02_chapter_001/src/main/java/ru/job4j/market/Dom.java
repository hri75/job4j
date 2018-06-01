package ru.job4j.market;

/**
 * задача "Биржевой стакан. [#1001]".
 *
 * @author Rustam Harisov <hri75@mail.ru>
 * @since 31.05.2018
 */

import java.util.*;

/**
 * Класс "Биржевой стакан" (англ. DOM, Depth of Market).
 */
public class Dom {
    /**
     * Идентификатор ценной бумаги.
     * Под ним же имеется ввиду эмитент, хотя, по-моему, это разные понятия.
     */
    private Book book;

    /**
     * Список заявок на покупку, упорядочен по убыванию цены,
     * чтобы при добавлении заявки на продажу взят первой выгодную цену.
     */
    private TreeSet<Order> bidOrders = new TreeSet<>(Collections.reverseOrder());

    /**
     * Список заявок на продажу, упорядочен по возрастанию цены,
     * такой порядок необходим при добавлении заявки на покупку, чтобы выгодную цену первой взять.
     */
    private TreeSet<Order> askOrders = new TreeSet<>();

    public Dom(Book book) {
        this.book = book;
    }

    public Book getBook() {
        return book;
    }

    /**
     * Обработать заявку (добавить в стакан или удалить из стакана).
     * @param order - заявка.
     */
    public void processOrder(Order order) {
        if (this.book == order.getBook()) {
            if (order.getType() == Type.ADD) {
                this.addOrder(order);
            } else {
                this.removeOrder(order);
            }
        }
    }

    /**
     * Добавление заявки в стакан.
     * @param order - заявка.
     *
     * Примечание: headSet используется, чтобы сразу выбрать нужные противоположные заявки.
     */
    private void addOrder(Order order) {
        TreeSet<Order> oppositeSet = (order.getAction() == Action.BID) ? askOrders : bidOrders;
        Order[] oppositeOrders = oppositeSet.headSet(order, true).toArray(new Order[0]);
        for (Order oppositeOrder : oppositeOrders) {
            if (oppositeOrder.getVolume() > order.getVolume()) {
                oppositeOrder.setVolume(oppositeOrder.getVolume() - order.getVolume());
                order.setVolume(0);
                break;
            } else {
                order.setVolume(order.getVolume() - oppositeOrder.getVolume());
                oppositeSet.remove(oppositeOrder);
                if (order.getVolume() == 0) {
                    break;
                }
            }
        }
        if (order.getVolume() > 0) {
            if (order.getAction() == Action.BID) {
                bidOrders.add(order);
            } else {
                askOrders.add(order);
            }
        }
    }

    /**
     * Метод возвращает просуммированный биржевой стакан, готовый к выводу на печать,
     * в виде списка Row.
     * @return - список Row.
     */
    public List<Row> getState() {
        List<Row> state = new ArrayList<>();
        TreeMap<Integer, Row> tradeMap = new TreeMap<>(Collections.reverseOrder());
        putOrders(tradeMap, bidOrders);
        putOrders(tradeMap, askOrders);
        state.addAll(tradeMap.values());
        return state;
    }

    /**
     * Метод добавляет в карту заявки, по окончании работы метода получается карта с просуммированными заявками.
     * @param tradeMap - карта с заявками.
     * @param setOrders - множество заявок, которые надо добавить в карту.
     */
    private void putOrders(TreeMap<Integer, Row> tradeMap, TreeSet<Order> setOrders) {
        Iterator<Order> iterator = setOrders.iterator();
        while (iterator.hasNext()) {
            Order currentOrder = iterator.next();
            Row row = tradeMap.get(currentOrder.getPrice());
            if (row == null) {
                if (currentOrder.getAction() == Action.BID) {
                    tradeMap.put(currentOrder.getPrice(), new Row(currentOrder.getPrice(), currentOrder.getVolume(), 0));
                } else {
                    tradeMap.put(currentOrder.getPrice(), new Row(currentOrder.getPrice(), 0, currentOrder.getVolume()));
                }
            } else {
                if (currentOrder.getAction() == Action.BID) {
                    row.bid += currentOrder.getVolume();
                } else {
                    row.ask += currentOrder.getVolume();
                }
            }
        }
    }

    /**
     * Метод выводит на экран биржевой стакан.
     * @param state - список Row.
     */
    public void display(List<Row> state) {
        System.out.println(this.book.getName());
        System.out.printf("%20s %20s %20s\n", "Покупка", "Цена", "Продажа");
        for (Row row : state) {
            System.out.printf("%20d %20d %20d\n", row.bid, row.price, row.ask);
        }
    }

    /**
     * Удаление заявки из стакана.
     * Точнее, удаляется количество из заявок, где цена = цене переданной заявки.
     * @param order - заявка на удаление.
     */
    private void removeOrder(Order order) {
        TreeSet<Order> currentSet = (order.getAction() == Action.BID) ? bidOrders : askOrders;
        Order[] currentOrders = currentSet.toArray(new Order[0]);
        for (Order currentOrder : currentOrders) {
            if (currentOrder.getPrice() == order.getPrice()) {
                if (currentOrder.getVolume() > order.getVolume()) {
                    currentOrder.setVolume(currentOrder.getVolume() - order.getVolume());
                    break;
                } else {
                    order.setVolume(order.getVolume() - currentOrder.getVolume());
                    currentSet.remove(currentOrder);
                    if (order.getVolume() <= 0) {
                        break;
                    }
                }
            }
        }
    }

    /**
     * Метод возвращает список противоположных заявок, которые можно совместить с текущей заявкой.
     * @param order - заявка.
     * @return - сортированное множество заявок, которые можно совместить с переданной заявкой.
     */
    private SortedSet<Order> getCombinedOrders(Order order) {
        SortedSet<Order> result;
        if (order.getAction() == Action.BID) {
            result = askOrders.headSet(order, true);
        } else {
            result = bidOrders.tailSet(order, true);
        }
        return result;
    }

    /**
     * Вспомогательный класс, хранит суммированное количество bid и ask по цене price.
     * Нужен для создания итоговой таблицы - биржевого стакана.
     */
    static class Row {
        private int price;
        private int bid;
        private int ask;

        public Row(int price, int bid, int ask) {
            this.price = price;
            this.bid = bid;
            this.ask = ask;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Row row = (Row) o;
            return price == row.price && bid == row.bid && ask == row.ask;
        }

        @Override
        public int hashCode() {
            int result = price;
            result = 31 * result + bid;
            result = 31 * result + ask;
            return result;
        }
    }
}
