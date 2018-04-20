package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test для класса Square.
 */
public class SquareTest {
    /**
     * Test для метода calculate для 3.
     */
    @Test
    public void whenBound3Then149() {
        int bound = 3;
        Square square = new Square();
        int[] result = square.calculate(bound);
        int[] expect = {1, 4, 9};
        assertThat(result, is(expect));
    }

    /**
     * Test для метода calculate для 4.
     */
    @Test
    public void whenBound4Then14916() {
        int bound = 4;
        Square square = new Square();
        int[] result = square.calculate(bound);
        int[] expect = {1, 4, 9, 16};
        assertThat(result, is(expect));
    }

    /**
     * Test для метода calculate для 5.
     */
    @Test
    public void whenBound5Then1491625() {
        int bound = 5;
        Square square = new Square();
        int[] result = square.calculate(bound);
        int[] expect = {1, 4, 9, 16, 25};
        assertThat(result, is(expect));
    }
}
