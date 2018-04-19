package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test для класса Factorial.
 */
public class FactorialTest {
    /**
     * Test для метода calc. 5!
     */
    @Test
    public void whenFactorial5Then120() {
        Factorial factorial = new Factorial();
        int result = factorial.calc(5);
        assertThat(result, is(120));
    }

    /**
     * Test для метода calc. 0!
     */
    @Test
    public void whenFactorialoThen1() {
        Factorial factorial = new Factorial();
        int result = factorial.calc(0);
        assertThat(result, is(1));
    }

}
