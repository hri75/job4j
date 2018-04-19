package ru.job4j.loop;

/**
 * Class Counter - обучение циклам.
 */
public class Counter {

    /**
     * Метод вычисляет сумму четныx чисел в диапазоне от start до finish.
     * @param start - начальное число диапазона.
     * @param finish - конечное число диапазона.
     * @return сумма четныx чисел в диапазоне от start до finish.
     */
    public int add(int start, int finish) {
        int result = 0;
        for (int i = start; i <= finish; i++) {
            if (i % 2 == 0) {
                result += i;
            }
        }
        return result;
    }
}
