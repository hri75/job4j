package ru.job4j.array;

/**
 * Класс FindLoop - поиск информации в массиве.
 */
public class FindLoop {
    /**
     * Метод indexOf
     * @param data - массив целочисленных чисел.
     * @param el   - число для поиска.
     * @return     - индекс элемента массива, в котором - искомое число (если нет, то возвращается -1).
     */
    public int indexOf(int[] data, int el) {
        int rst = -1; // если элемента нет в массиве, то возвращаем -1.
        for (int index = 0; index < data.length; index++) {
            if (data[index] == el) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}
