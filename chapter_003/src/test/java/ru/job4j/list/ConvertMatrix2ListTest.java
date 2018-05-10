package ru.job4j.list;


import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест класса ConvertMatrix2List
 */
public class ConvertMatrix2ListTest {
    /**
     * Тест - матрица 2 х 2 превращается в список из 4-х элементов.
     */
    @Test
    public void when2on2ArrayThenList4() {
        int[][] input = {{1, 2}, {3, 4}};
        ConvertMatrix2List converter = new ConvertMatrix2List();
        List<Integer> result = converter.toList(input);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4);
        assertThat(result, is(expected));
    }
}
