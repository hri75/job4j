package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class DynamicLinkedListTest {

    private DynamicLinkedList<Integer> dynamicLinkedList;

    @Before
    public void setUp() {
        dynamicLinkedList = new DynamicLinkedList<>();
    }

    @Test
    public void whenAddAndGet() {
        dynamicLinkedList.add(0);
        dynamicLinkedList.add(1);
        dynamicLinkedList.add(2);
        assertThat(dynamicLinkedList.get(0), is(0));
        assertThat(dynamicLinkedList.get(1), is(1));
        assertThat(dynamicLinkedList.get(2), is(2));
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void whenWrondIndex() {
        dynamicLinkedList.add(0);
        dynamicLinkedList.get(1);
    }

    @Test
    public void whenIteratorWorkProperly() {
        dynamicLinkedList.add(0);
        dynamicLinkedList.add(1);
        dynamicLinkedList.add(2);
        Iterator<Integer> iterator = dynamicLinkedList.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(0));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.hasNext(), is(false));
        assertThat(iterator.hasNext(), is(false));
    }

    @Test (expected = ConcurrentModificationException.class)
    public void whenIteratorThrowsConcurrentException() {
        dynamicLinkedList.add(0);
        dynamicLinkedList.add(1);
        dynamicLinkedList.add(2);
        Iterator<Integer> iterator = dynamicLinkedList.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(0));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(1));
        dynamicLinkedList.add(3);
        iterator.next();
    }

    @Test (expected = NullPointerException.class)
    public void whenIteratorThrowsNullPointerException() {
        Iterator<Integer> iterator = dynamicLinkedList.iterator();
        iterator.next();
    }
}