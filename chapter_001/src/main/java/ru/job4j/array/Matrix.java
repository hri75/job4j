package ru.job4j.array;

import java.util.Arrays;

/**
 * Класс Matrix - таблица умножения.
 */
public class Matrix {
    /**
     * Метод multiple - заполнение таблицы умножения.
     * @param size - размер таблицы.
     * @return - заполненный двумерный массив.
     */
    public int[][] multiple(int size) {
        int[][] array = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                array[i][j] = (i + 1) * (j + 1);
            }
        }
        return array;
    }
}

