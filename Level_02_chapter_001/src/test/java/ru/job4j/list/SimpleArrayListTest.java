package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;

public class SimpleArrayListTest {

    private SimpleArrayList<Integer> list;

    @Before
    public void setUp() {
        list = new SimpleArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
    }

    @Test
    public void whenAddThreeElementsThenUseGetOneResultTwo() {
        assertThat(list.get(1), is(2));
    }

    @Test
    public void whenAddThreeElementsThenUseGetSizeResultThree() {
        assertThat(list.getSize(), is(3));
    }

    @Test
    public void whenDelete1() {
        assertThat(list.delete(), is(3));
        assertThat(list.getSize(), is(2));
        assertThat(list.get(0), is(2));
    }

    @Test
    public void whenDelete3Times() {
        assertThat(list.delete(), is(3));
        assertThat(list.getSize(), is(2));
        assertThat(list.get(0), is(2));
        assertThat(list.delete(), is(2));
        assertThat(list.getSize(), is(1));
        assertThat(list.get(0), is(1));
        assertThat(list.delete(), is(1));
        assertThat(list.getSize(), is(0));
    }

}