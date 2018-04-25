package ru.job4j.arrays;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Тест для класса Merger.
 */
public class MergerTest {
    /**
     * Два массива в шахматном порядке сливаются.
     */
    @Test
    public void whenTwoArraysThenThird() {
        int[] first = {1, 3, 5, 7, 9, 12, 14, 15};
        int[] second = {2, 4, 6, 8, 10, 11, 13, 16, 98, 99};
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 98, 99};
        Merger merger = new Merger();
        int[] result = merger.merge(first, second);
        assertThat(expected, is(result));
    }

    /**
     * В первом массиве все элементы меньше, чем во втором.
     */
    @Test
    public void whenFirstArrayLessThanSecondThenThird() {
        int[] first = {1, 2, 3, 10, 11};
        int[] second = {22, 24, 26, 28};
        int[] expected = {1, 2, 3, 10, 11, 22, 24, 26, 28};
        Merger merger = new Merger();
        int[] result = merger.merge(first, second);
        assertThat(expected, is(result));
    }

    /**
     * Во втором массиве все элементы меньше, чем в первом.
     */
    @Test
    public void whenSecondArrayLessThanFirstThenThird() {
        int[] first = {99, 100, 102};
        int[] second = {1, 2, 3, 4};
        int[] expected = {1, 2, 3, 4, 99, 100, 102};
        Merger merger = new Merger();
        int[] result = merger.merge(first, second);
        assertThat(expected, is(result));
    }

    /**
     * Второй массив "лежит" внутри первого.
     */
    @Test
    public void whenSecondLiesIntoFirstThird() {
        int[] first = {1, 2, 3, 98, 99};
        int[] second = {5, 7, 9};
        int[] expected = {1, 2, 3, 5, 7, 9, 98, 99};
        Merger merger = new Merger();
        int[] result = merger.merge(first, second);
        assertThat(expected, is(result));
    }

}
