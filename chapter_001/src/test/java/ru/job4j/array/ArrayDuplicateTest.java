package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test для класса ArrayDuplicate.
 */
public class ArrayDuplicateTest {
    /**
     * Test для метода remove когда 6 слов.
     */
    @Test
    public void when6WordsThen3() {
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] input = {"Привет", "Мир", "Привет", "Супер", "Привет", "Мир"};
        String[] result = arrayDuplicate.remove(input);
        String[] expected = {"Привет", "Мир", "Супер"};
        assertThat(result, is(expected));
    }
    /**
     * Test для метода remove когда 3 слова.
     */
    @Test
    public void when3WordsThen2() {
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] input = {"Привет", "Привет", "Мир"};
        String[] result = arrayDuplicate.remove(input);
        String[] expected = {"Привет", "Мир"};
        assertThat(result, is(expected));
    }

    /**
     * Test для метода remove когда 2 слова.
     */
    @Test
    public void when2WordsThen2() {
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] input = {"Привет", "Мир"};
        String[] result = arrayDuplicate.remove(input);
        String[] expected = {"Привет", "Мир"};
        assertThat(result, is(expected));
    }

    /**
     * Test для метода remove когда 1 слово.
     */
    @Test
    public void when1WordsThen1() {
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] input = {"Привет"};
        String[] result = arrayDuplicate.remove(input);
        String[] expected = {"Привет"};
        assertThat(result, is(expected));
    }

    /**
     * Test для метода remove когда 1 слово.
     */
    @Test
    public void whenAllWordsUnique() {
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] input = {"Привет", "Мир", "Труд", "Май"};
        String[] result = arrayDuplicate.remove(input);
        String[] expected = {"Привет", "Мир", "Труд", "Май"};
        assertThat(result, is(expected));
    }

    /**
     * Test для метода remove когда 1 слово.
     */
    @Test
    public void whenAllWordsNotUnique() {
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] input = {"Привет", "Привет", "Привет", "Привет"};
        String[] result = arrayDuplicate.remove(input);
        String[] expected = {"Привет"};
        assertThat(result, is(expected));
    }
}
