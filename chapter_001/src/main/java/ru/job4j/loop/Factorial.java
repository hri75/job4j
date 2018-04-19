package ru.job4j.loop;

/**
 * Class Factorial - вычисление факториала.
 */
public class Factorial {
    /**
     * Метод вычисляет факториал.
     *
     * @param n - положительное целое число n.
     * @return факториал числа n.
     */
    public int calc(int n) {
        int result = 1;
        for (int i = result; i <= n; i++) {
            result = result * i;
        }
        return result;
    }
}
