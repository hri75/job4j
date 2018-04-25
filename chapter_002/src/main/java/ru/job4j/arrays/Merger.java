package ru.job4j.arrays;

/**
 * Класс для слияния массивов.
 */
public class Merger {
    /**
     * Сливает два отсортированных по возрастанию массива в один, тоже отсортированный по возрастанию.
     * @param first - первый массив целых чисел, отсортированный по возрастанию.
     * @param second - второй массив целых чисел, отсортированный по возрастанию.
     * @return - массив, включающий в себя два, тоже отсортированный по возрастанию.
     */
    public int[] merge(int[] first, int[] second) {
        int index1 = 0;
        int index2 = 0;
        int index3 = 0;

        int[] third = new int[first.length + second.length];

        while (index1 < first.length || index2 < second.length) {
            if (index1 >= first.length) {
                third[index3++] = second[index2++];
            } else if (index2 >= second.length) {
                third[index3++] = first[index1++];
            } else if (first[index1] < second[index2]) {
                third[index3++] = first[index1++];
            } else {
                third[index3++] = second[index2++];
            }
        }
        return third;
    }
}
