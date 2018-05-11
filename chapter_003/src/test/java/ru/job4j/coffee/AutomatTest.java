package ru.job4j.coffee;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
/**
 * Тест класса Automat.
 */
public class AutomatTest {
    /**
     * купюра = 50, цена кофе = 35
     */
    @Test
    public void whenVolume50Price35() {
        Automat automat = new Automat();
        int[] result = automat.changes(50, 35);
        int[] expected = {10, 5};
        assertThat(result, is(expected));
    }

    /**
     * купюра = 50, цена кипятка = 4
     */
    @Test
    public void whenVolume50Price4() {
        Automat automat = new Automat();
        int[] result = automat.changes(50, 4);
        int[] expected = {10, 10, 10, 10, 5, 1};
        assertThat(result, is(expected));
    }
}
