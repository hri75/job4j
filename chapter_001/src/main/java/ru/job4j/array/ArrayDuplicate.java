package ru.job4j.array;

import java.util.Arrays;

/**
 * Класс ArrayDuplicate - убирает из массива слов дублирующиеся слова.
 */
public class ArrayDuplicate {
    /**
     * Метод remove - убирает из переданного массива слов дублирующиеся слова.
     *
     * @param array - переданный массив слов.
     * @return - массив без дублирующихся слов.
     */
    public String[] remove(String[] array) {
        int duplic = 0;
        String temp;
        for (int i = 0; i < array.length - duplic - 1; i++) {
            for (int j = i + 1; j < array.length - duplic; j++) {
                if (array[i].equals(array[j])) {
                    duplic++;
                    temp = array[j];
                    for (int k = j; k < array.length - 1; k++) {
                        array[k] = array[k + 1];
                    }
                    array[array.length - 1] = temp;
                    j--;
                }
            }
        }
        return Arrays.copyOf(array, array.length - duplic);
    }
}




