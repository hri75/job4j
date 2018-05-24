package ru.job4j.set;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;

public class SimpleLinkedSetTest {

    private SimpleLinkedSet<Integer> simpleLinkedSet;

    @Before
    public void setUp() {
        simpleLinkedSet = new SimpleLinkedSet<>();
    }

    @Test
    public void whenManyAddOne() {
        simpleLinkedSet.add(1);
        simpleLinkedSet.add(1);
        simpleLinkedSet.add(1);
        Iterator<Integer> iterator = simpleLinkedSet.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.hasNext(), is(false));
    }

    @Test
    public void whenManyAddNull() {
        simpleLinkedSet.add(null);
        simpleLinkedSet.add(null);
        simpleLinkedSet.add(null);
        Iterator<Integer> iterator = simpleLinkedSet.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(nullValue()));
        assertThat(iterator.hasNext(), is(false));
    }

    @Test
    public void whenManyAddDifferentValues() {
        simpleLinkedSet.add(1);
        simpleLinkedSet.add(2);
        simpleLinkedSet.add(3);
        Iterator<Integer> iterator = simpleLinkedSet.iterator();
        int sum = 0;
        while (iterator.hasNext()) {
            sum += iterator.next();
        }
        assertThat(sum, is(6));
    }
}