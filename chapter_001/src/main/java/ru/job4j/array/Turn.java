package ru.job4j.array;

/**
 * Класс Turn - переворот массива.
 */
public class Turn {
    /**
     * Метод back - переворачивает элементы массива задом наперед.
     * @param array - исходный массив целых чисел.
     * @return - возвращаем тот же массив, но с переставленными задом наперед элементами.
     */
    public int[] back(int[] array) {
        int temp;
        for (int i = 0; i < array.length / 2; i++) {
            temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
        return array;
    }
}
