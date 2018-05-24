package ru.job4j.set;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleSetTest {

    private SimpleSet<Integer> simpleSet;

    @Before
    public void setUp() {
        simpleSet = new SimpleSet<>();
    }

    @Test
    public void whenManyAdd() {
        simpleSet.add(1);
        simpleSet.add(1);
        simpleSet.add(1);
        Iterator<Integer> iterator = simpleSet.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.hasNext(), is(false));
    }
}