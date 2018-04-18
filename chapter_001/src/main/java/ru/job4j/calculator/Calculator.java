package ru.job4j.calculator;

/**
 * Class Calculator - класс для выполнения арифметических операций.
 * @author Harisov Rustam (hri75@mail.ru).
 */
public class Calculator {
    private double result;

    /**
     * Метод для сложения двух чисел.
     * @param first
     * @param second
     */
    public void add(double first, double second) {
        this.result = first + second;
    }

    /**
     * Метод для вычитания.
     * @param first
     * @param second
     */
    public void subtract(double first, double second) {
        this.result = first - second;
    }

    /**
     * Метод для умножения.
     * @param first
     * @param second
     */
    public void multiply(double first, double second) {
        this.result = first * second;
    }

    /**
     * Метод для деления.
     * @param first
     * @param second
     */
    public void div(double first, double second) {
        this.result = first / second;
    }

    /**
     * Метод возвращает значение result.
     * @return result
     */
    public double getResult() {
        return this.result;
    }
}
