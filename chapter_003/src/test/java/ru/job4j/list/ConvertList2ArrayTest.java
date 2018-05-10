package ru.job4j.list;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест класса ConvertList2Array.
 */
public class ConvertList2ArrayTest {
    /**
     * 7 на 3 ряда.
     */
    @Test
    public void when7ElementsThen9() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7),
                3
        );
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 0, 0}
        };
        assertThat(result, is(expect));
    }

    /**
     * 7 на 4 ряда.
     */
    @Test
    public void when7ElementsThen8() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7),
                4
        );
        int[][] expect = {
                {1, 2},
                {3, 4},
                {5, 6},
                {7, 0}
        };
        assertThat(result, is(expect));
    }

    /**
     * 6 на 1 ряд.
     */
    @Test
    public void when6ElementsThenSimple() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6),
                1
        );
        int[][] expect = {
                {1, 2, 3, 4, 5, 6}
        };
        assertThat(result, is(expect));
    }
    /**
     * 6 на 3 ряда.
     */
    @Test
    public void when6ElementsThen6() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6),
                3
        );
        int[][] expect = {
                {1, 2},
                {3, 4},
                {5, 6}
        };
        assertThat(result, is(expect));
    }
}
