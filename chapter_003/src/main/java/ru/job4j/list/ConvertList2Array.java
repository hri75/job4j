package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

/**
 * Конвертер ArrayList в двумерный массив.
 * Примечание: надо помнить, что ячейки массива при создании целочисленного массива устанавливаются по-умолчанию в 0.
 */
public class ConvertList2Array {
    /**
     * Метод конвертирует переданный список в двумерный массив.
     * @param list - список.
     * @param rows - количество рядов в массиве.
     * @return - двумерный массив.
     */
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = list.size() / rows + (list.size() % rows == 0 ?  0 :  1);
        int[][] array = new int[rows][cells];
        int currentRow = 0;
        int currentCell = 0;
        for (Integer value: list) {
            array[currentRow][currentCell] = value;
            currentCell++;
            if (currentCell >= cells) {
                currentRow++;
                currentCell = 0;
            }
        }
        return array;
    }

    /**
     * Метод конвертирует лист массивов в один лист Integer.
     * @param list - лист массивов.
     * @return - лист Integer.
     */
    public List<Integer> convert(List<int[]> list) {
        List<Integer> result = new ArrayList<>();
        for (int[] array: list) {
            for (int value: array) {
                result.add(value);
            }
        }
        return result;
    }
}
