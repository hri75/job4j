package ru.job4j.set;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;

public class AnotherSimpleSetTest {

    private AnotherSimpleSet<Integer> anotherSimpleSet;

    @Before
    public void setUp() {
        anotherSimpleSet = new AnotherSimpleSet<>();
    }

    @Test
    public void whenManyAddOne() {
        anotherSimpleSet.add(1);
        anotherSimpleSet.add(1);
        anotherSimpleSet.add(1);
        Iterator<Integer> iterator = anotherSimpleSet.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.hasNext(), is(false));
    }

    @Test
    public void whenManyAddNull() {
        anotherSimpleSet.add(null);
        anotherSimpleSet.add(null);
        anotherSimpleSet.add(null);
        Iterator<Integer> iterator = anotherSimpleSet.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(nullValue()));
        assertThat(iterator.hasNext(), is(false));
    }

    @Test
    public void whenManyAddDifferentValues() {
        anotherSimpleSet.add(1);
        anotherSimpleSet.add(2);
        anotherSimpleSet.add(3);
        Iterator<Integer> iterator = anotherSimpleSet.iterator();
        int sum = 0;
        while (iterator.hasNext()) {
            sum += iterator.next();
        }
        assertThat(sum, is(6));
    }
}