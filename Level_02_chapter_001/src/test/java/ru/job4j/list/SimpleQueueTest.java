package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleQueueTest {

    private SimpleQueue<Integer> simpleQueue;

    @Before
    public void setUp() {
        simpleQueue = new SimpleQueue<>();
    }

    @Test
    public void whenPollAndPush() {
        simpleQueue.push(1);
        simpleQueue.push(2);
        simpleQueue.push(3);

        assertThat(simpleQueue.poll(), is(1));
        assertThat(simpleQueue.poll(), is(2));
        assertThat(simpleQueue.poll(), is(3));
    }
}

