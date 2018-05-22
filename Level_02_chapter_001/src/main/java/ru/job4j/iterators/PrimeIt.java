package ru.job4j.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Итератор для простых чисел.
 */
public class PrimeIt implements Iterator {
    private final int[] numbers;
    private int index;

    /**
     * Конструктор.
     * @param numbers  - массив из чисел.
     */
    public PrimeIt(final int[] numbers) {
        this.numbers = numbers;
        this.index = -1;
        this.moveCarriage();
    }

    @Override
    public boolean hasNext() {
        return index < numbers.length;
    }

    @Override
    public Object next() {
        int result = 0;
        try {
            result = numbers[index];
        } catch (ArrayIndexOutOfBoundsException ex) {
            throw new NoSuchElementException();
        }
        moveCarriage();
        return result;
    }

    /**
     * Метод двигает "каретку" по массиву.
     */
    private void moveCarriage() {
        for (++index; index < numbers.length; index++) {
            if (isPrime(numbers[index])) {
                break;
            }
        }
    }

    /**
     * Метод проверяет - простое ли число.
     * @param number - число.
     * @return - Истина - число простое, Ложь - непростое.
     *
     * Примечание: проверять имеет смысл до корня из number, но чтобы корень не вычислять, i*i < number
     */
    private boolean isPrime(int number) {
        boolean result = true;
        if (number > 1) {
            for (int i = 2; i * i <= number; i++) {
                if (number % i == 0) {
                    result = false;
                    break;
                }
            }
        } else {
            result = false;
        }
        return result;
    }
}
