package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleStackTest {

    private SimpleStack<Integer> simpleStack;

    @Before
    public void setUp() {
        simpleStack = new SimpleStack<>();
    }

    @Test
    public void whenPollAndPush() {
        simpleStack.push(1);
        simpleStack.push(2);
        simpleStack.push(3);

        assertThat(simpleStack.poll(), is(3));
        assertThat(simpleStack.poll(), is(2));
        assertThat(simpleStack.poll(), is(1));
    }
}