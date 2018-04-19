package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test для класса Counter
 */

public class CounterTest {
    /**
     * Test метода add
     */
    @Test
    public void whenFrom1to10Then30() {
        Counter counter = new Counter();
        int result = counter.add(1, 10);
        assertThat(result, is(30));
    }

}
