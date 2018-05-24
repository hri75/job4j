package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class CycleListTest {

    private CycleList cycleList = new CycleList();
    private CycleList.Node first;
    private CycleList.Node two;
    private CycleList.Node third;
    private CycleList.Node four;

    @Before
    public void setUp() {
        first = cycleList.new Node(1);
        two = cycleList.new Node(2);
        third = cycleList.new Node(3);
        four = cycleList.new Node(4);
    }

    @Test
    public void whenHasBigCycle() {
        first.next = two;
        two.next = third;
        third.next = four;
        four.next = first;
        assertThat(cycleList.hasCycle(first), is(true));
    }

    @Test
    public void whenHasSmallCycle() {
        first.next = two;
        two.next = third;
        third.next = two;
        assertThat(cycleList.hasCycle(first), is(true));
    }

    @Test
    public void whenHasNoCycle() {
        first.next = two;
        two.next = third;
        third.next = four;
        assertThat(cycleList.hasCycle(first), is(false));
    }
}