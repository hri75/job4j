package ru.job4j.set;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleHashTableSetTest {
    private SimpleHashTableSet<Integer> simpleHashTableSet;

    @Before
    public void setUp() {
        simpleHashTableSet = new SimpleHashTableSet<>();
    }

    @Test
    public void whenAddAndContain() {
        simpleHashTableSet.add(1);
        simpleHashTableSet.add(2);
        simpleHashTableSet.add(3);
        simpleHashTableSet.add(4);
        simpleHashTableSet.add(5);
        simpleHashTableSet.add(null);
        assertThat(simpleHashTableSet.contains(null), is(true));
    }

    @Test
    public void whenRemoveAndContain() {
        simpleHashTableSet.add(1);
        simpleHashTableSet.add(2);
        simpleHashTableSet.add(3);
        simpleHashTableSet.add(4);
        simpleHashTableSet.add(null);
        assertThat(simpleHashTableSet.contains(null), is(true));
        assertThat(simpleHashTableSet.remove(1), is(true));
        assertThat(simpleHashTableSet.remove(4), is(true));
        assertThat(simpleHashTableSet.remove(5), is(false));
        assertThat(simpleHashTableSet.remove(null), is(true));
        assertThat(simpleHashTableSet.contains(1), is(false));
        assertThat(simpleHashTableSet.contains(4), is(false));
        assertThat(simpleHashTableSet.contains(null), is(false));
    }
}