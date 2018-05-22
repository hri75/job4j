package ru.job4j.generic;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Тест для класса SimpleArray.
 */
public class SimpleArrayTest {
    @Test
    public void whenAddAndGet() {
        SimpleArray<String> simpleArray = new SimpleArray<>(10);
        simpleArray.add("test1");
        assertThat(simpleArray.get(0), is("test1"));
    }

    @Test
    public void whenSet() {
        SimpleArray<String> simpleArray = new SimpleArray<>(10);
        simpleArray.add("test1");
        simpleArray.add("test2");
        simpleArray.set(1, "test3");
        assertThat(simpleArray.get(1), is("test3"));
    }

    @Test
    public void whenDelete() {
        SimpleArray<String> simpleArray = new SimpleArray<>(10);
        simpleArray.add("test1");
        simpleArray.add("test2");
        simpleArray.add("test3");
        simpleArray.add("test4");
        simpleArray.add("test5");
        simpleArray.delete(1);
        assertThat(simpleArray.get(1), is("test3"));
        assertThat(simpleArray.get(2), is("test4"));
        assertThat(simpleArray.get(3), is("test5"));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenIndexInGetWithError() {
        SimpleArray<String> simpleArray = new SimpleArray<>(10);
        simpleArray.add("test1");
        simpleArray.get(1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenIndexInSetWithError() {
        SimpleArray<String> simpleArray = new SimpleArray<>(10);
        simpleArray.add("test1");
        simpleArray.set(1, "test2");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenIndexInDeleteWithError() {
        SimpleArray<String> simpleArray = new SimpleArray<>(10);
        simpleArray.add("test1");
        simpleArray.delete(1);
    }

    @Test(expected = RuntimeException.class)
    public void whenAddOverflow() {
        SimpleArray<String> simpleArray = new SimpleArray<>(1);
        simpleArray.add("test1");
        simpleArray.add("test2");
    }

    @Test
    public void whenIterator() {
        SimpleArray<String> simpleArray = new SimpleArray<>(10);
        simpleArray.add("test1");
        simpleArray.add("test2");
        simpleArray.add("test3");
        Iterator<String> iterator = simpleArray.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is("test1"));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is("test2"));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is("test3"));
        assertThat(iterator.hasNext(), is(false));
    }
}