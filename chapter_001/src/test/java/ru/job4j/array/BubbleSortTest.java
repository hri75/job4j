package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Test для класса BubbleSort.
 */
public class BubbleSortTest {
    /**
     * Test для метода sort для массива с нечетным кол-вом элементов.
     */
    @Test
    public void whenArray321Then123() {
        BubbleSort bubbleSort = new BubbleSort();
        int[] input = {3, 2, 1};
        int[] result = bubbleSort.sort(input);
        int[] expected = {1, 2, 3};
        assertThat(result, is(expected));
    }

    /**
     * Test для метода sort для массива с четным кол-вом элементов.
     */
    @Test
    public void whenArray4321Then1234() {
        BubbleSort bubbleSort = new BubbleSort();
        int[] input = {4, 3, 2, 1};
        int[] result = bubbleSort.sort(input);
        int[] expected = {1, 2, 3, 4};
        assertThat(result, is(expected));
    }

    /**
     * Test для метода sort для массива из 10 элементов.
     */
    @Test
    public void whenSortArrayWithTenElementsThenSortedArray() {
        //напишите здесь тест, проверяющий сортировку массива из 10 элементов методом пузырька, например {1, 5, 4, 2, 3, 1, 7, 8, 0, 5}.
        BubbleSort bubbleSort = new BubbleSort();
        int[] input = {1, 5, 4, 2, 3, 1, 7, 8, 0, 5};
        int[] result = bubbleSort.sort(input);
        int[] expected = {0, 1, 1, 2, 3, 4, 5, 5, 7, 8};
        assertThat(result, is(expected));
    }
}
