package ru.job4j.market;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * @author Rustam Harisov <hri75@mail.ru>
 * @since 01.06.2018
 */

/**
 * Тест для класса Dom.
 */
public class DomTest {
    private Book book;
    private Dom dom;


    @Before
    public void setUp() {
        book = new Book("Газпром");
        dom = new Dom(book);
        dom.processOrder(new Order(book, Type.ADD, Action.ASK, 130, 143));
        dom.processOrder(new Order(book, Type.ADD, Action.ASK, 131, 195));
        dom.processOrder(new Order(book, Type.ADD, Action.ASK, 139, 1000));
        dom.processOrder(new Order(book, Type.ADD, Action.BID, 125, 32));
        dom.processOrder(new Order(book, Type.ADD, Action.BID, 121, 800));
        dom.processOrder(new Order(book, Type.ADD, Action.BID, 121, 4));
        dom.processOrder(new Order(book, Type.ADD, Action.BID, 121, 1));
        dom.processOrder(new Order(book, Type.ADD, Action.BID, 115, 900));
        dom.processOrder(new Order(book, Type.ADD, Action.BID, 115, 48));
        dom.processOrder(new Order(book, Type.ADD, Action.ASK, 132, 777));
    }

    @Test
    public void whenAdded10Orders() {
        List<Dom.Row> result = dom.getState();
        List<Dom.Row> expected = new ArrayList<>();
        expected.add(new Dom.Row(139, 0, 1000));
        expected.add(new Dom.Row(132, 0, 777));
        expected.add(new Dom.Row(131, 0, 195));
        expected.add(new Dom.Row(130, 0, 143));
        expected.add(new Dom.Row(125, 32, 0));
        expected.add(new Dom.Row(121, 805, 0));
        expected.add(new Dom.Row(115, 948, 0));
        assertThat(result, is(expected));
    }

    @Test
    public void whenDeletedThreeOrder() {
        dom.processOrder(new Order(book, Type.DELETE, Action.BID, 115, 947));
        dom.processOrder(new Order(book, Type.DELETE, Action.ASK, 132, 778));
        dom.processOrder(new Order(book, Type.DELETE, Action.ASK, 132, 66));
        List<Dom.Row> result = dom.getState();
        List<Dom.Row> expected = new ArrayList<>();
        expected.add(new Dom.Row(139, 0, 1000));
        expected.add(new Dom.Row(131, 0, 195));
        expected.add(new Dom.Row(130, 0, 143));
        expected.add(new Dom.Row(125, 32, 0));
        expected.add(new Dom.Row(121, 805, 0));
        expected.add(new Dom.Row(115, 1, 0));
        assertThat(result, is(expected));
    }

    @Test
    public void whenAddedBidAndAsk() {
        dom.processOrder(new Order(book, Type.ADD, Action.BID, 132, 196));
        dom.processOrder(new Order(book, Type.ADD, Action.ASK, 120, 5));
        List<Dom.Row> result = dom.getState();
        List<Dom.Row> expected = new ArrayList<>();
        expected.add(new Dom.Row(139, 0, 1000));
        expected.add(new Dom.Row(132, 0, 777));
        expected.add(new Dom.Row(131, 0, 142));
        expected.add(new Dom.Row(125, 27, 0));
        expected.add(new Dom.Row(121, 805, 0));
        expected.add(new Dom.Row(115, 948, 0));
        assertThat(result, is(expected));
    }
}