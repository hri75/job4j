package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class DynamicArrayListTest {

    private DynamicArrayList<Integer> dynamicArrayList;

    @Before
    public void setUp() {
        dynamicArrayList = new DynamicArrayList<>();
    }

    @Test
    public void whenAddManyElements() {
        dynamicArrayList.add(0);
        dynamicArrayList.add(1);
        dynamicArrayList.add(2);
        dynamicArrayList.add(3);
        dynamicArrayList.add(4);
        dynamicArrayList.add(5);
        dynamicArrayList.add(6);
        assertThat(dynamicArrayList.get(2), is(2));
    }

    @Test
    public void whenIteratorWorkProperly() {
        dynamicArrayList.add(0);
        dynamicArrayList.add(1);
        dynamicArrayList.add(2);
        dynamicArrayList.add(3);
        dynamicArrayList.add(4);
        dynamicArrayList.add(5);
        dynamicArrayList.add(6);
        Iterator<Integer> iterator = dynamicArrayList.iterator();
        iterator.next();
        iterator.next();
        iterator.next();
        assertThat(iterator.next(), is(3));
    }

    @Test (expected = ConcurrentModificationException.class)
    public void whenIteratorThrowsException() {
        dynamicArrayList.add(0);
        dynamicArrayList.add(1);
        dynamicArrayList.add(2);
        Iterator<Integer> iterator = dynamicArrayList.iterator();
        iterator.next();
        iterator.next();
        dynamicArrayList.add(3);
        iterator.next();
    }

}