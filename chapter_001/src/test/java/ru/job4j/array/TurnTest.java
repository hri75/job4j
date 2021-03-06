package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Test для класса Turn.
 */
public class TurnTest {
    /**
     * Test для метода back для нечетного числа элементов массива.
     */
    @Test
    public void whenTurnArrayWithEvenAmountOfElementsThenTurnedArray() {
        Turn turner = new Turn();
        int[] input = new int[] {1, 2, 3, 4, 5};
        int[] result = turner.back(input);
        int[] expect = new int[] {5, 4, 3, 2, 1};
        assertThat(result, is(expect));
    }

    /**
     * Test для метода back для четного числа элементов массива.
     */
    @Test
    public void whenTurnArrayWithOddAmountOfElementsThenTurnedArray() {
        //напишите здесь тест, проверяющий переворот массива с чётным числом элементов, например {1, 2, 3, 4}.
        Turn turner = new Turn();
        int[] input = {1, 2, 3, 4};
        int[] result = turner.back(input);
        int[] expect = {4, 3, 2, 1};
        assertThat(result, is(expect));

    }
}