package ru.job4j.map;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;

public class SimpleHashMapTest {

    private SimpleHashMap<Integer, String> simpleHashMap;

    @Before
    public void setUp() {
        simpleHashMap = new SimpleHashMap<>();
    }

    @Test
    public void whenInsert() {
        assertThat(simpleHashMap.insert(1, "AAA"), is(true));
        assertThat(simpleHashMap.insert(1, "BBB"), is(false));
    }

    @Test
    public void whenGet() {
        simpleHashMap.insert(1, "AAA");
        simpleHashMap.insert(2, "BBB");
        assertThat("AAA".equals(simpleHashMap.get(1)), is(true));
        assertThat("BBB".equals(simpleHashMap.get(2)), is(true));
        assertThat(simpleHashMap.get(3), is(nullValue()));
    }

    @Test
    public void whenDelete() {
        simpleHashMap.insert(1, "AAA");
        simpleHashMap.insert(2, "BBB");
        assertThat(simpleHashMap.delete(1), is(true));
        assertThat(simpleHashMap.delete(1), is(false));
        assertThat(simpleHashMap.delete(2), is(true));
        assertThat(simpleHashMap.delete(2), is(false));
        assertThat(simpleHashMap.delete(3), is(false));
    }

    @Test
    public void whenIterator() {
        simpleHashMap.insert(1, "AAA");
        simpleHashMap.insert(2, "BBB");
        simpleHashMap.insert(3, "CCC");
        Iterator<SimpleHashMap.Node<Integer, String>> iterator = simpleHashMap.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.hasNext(), is(true));
        assertThat("AAA".equals(iterator.next().getValue()), is(true));
        assertThat("BBB".equals(iterator.next().getValue()), is(true));
        assertThat("CCC".equals(iterator.next().getValue()), is(true));
        assertThat(iterator.hasNext(), is(false));
        assertThat(iterator.hasNext(), is(false));
    }

    @Test
    public void whenResize() {
        simpleHashMap.insert(0, "000");
        simpleHashMap.insert(1, "111");
        simpleHashMap.insert(2, "222");
        simpleHashMap.insert(3, "333");
        simpleHashMap.insert(4, "444");
        simpleHashMap.insert(5, "555");
        simpleHashMap.insert(6, "666");
        simpleHashMap.insert(7, "777");
        simpleHashMap.insert(8, "888");
        simpleHashMap.insert(9, "999");
        simpleHashMap.insert(10, "AAA");
        simpleHashMap.insert(11, "BBB");
        simpleHashMap.insert(12, "CCC");
        simpleHashMap.insert(13, "DDD");
        simpleHashMap.insert(14, "EEE");
        simpleHashMap.insert(15, "FFF");
        assertThat(simpleHashMap.insert(16, "GGG"), is(true));
        assertThat(simpleHashMap.insert(17, "HHH"), is(true));
    }
}