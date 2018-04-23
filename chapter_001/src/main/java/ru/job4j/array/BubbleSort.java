package ru.job4j.array;

/**
 * Класс BubbleSort - сортировка массива из целых чисел.
 */
public class BubbleSort {
    /**
     * Метод sort - сортировка методом "пузырька".
     * @param array - исходный массив.
     * @return - отсортированный массив.
     */
    public int[] sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }
}
