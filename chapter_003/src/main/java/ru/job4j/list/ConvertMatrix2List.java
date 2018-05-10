package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

/**
 * Конвертер двумерного массива в список.
 */
public class ConvertMatrix2List {
    /**
     * Метод конвертирует двумерный целочисленный массив в список.
     * @param array - целочисленный двумерный массив.
     * @return - список.
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] currentArray : array) {
            for (int value : currentArray) {
                list.add(value);
            }
        }
        return list;
    }
}

