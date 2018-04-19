package ru.job4j.max;

/**
 * Class Max - вычисление максимального значения из двух целых чисел.
 */
public class Max {

    /**
     * Метод max возвращает максимальное из двух целых чисел.
     * @param first - первое целое число.
     * @param second - второе целое число.
     * @return - максимальное из двух целых чисел.
     */
    public int max(int first, int second) {
        return first > second ? first : second;
    }

    /**
     * Метод max возвращает максимальное из трех целых чисел.
     * @param first - первое целое число.
     * @param second - второе целое число.
     * @param third  - третье целое число.
     * @return - максимальное из трех целых чисел.
     */
    public int max(int first, int second, int third) {
        int temp = this.max(first, second);
        temp = this.max(temp, third);
        return temp;
    }

}
