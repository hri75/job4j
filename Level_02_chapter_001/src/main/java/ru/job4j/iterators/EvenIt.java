package ru.job4j.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

/**
 * Итератор по четным числам.
 */
public class EvenIt implements Iterator {

    private final int[] numbers;
    private int index;

    /**
     * Конструктор.
     * @param numbers - массив целых чисел.
     */
    public EvenIt(final int[] numbers) {
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
            if (numbers[index] % 2 == 0) {
                break;
            }
        }
    }

    /**
     * Метод remove не реализую, поэтому прокидываю исключение UnsupportedOperationException.
     */
    @Override
    public void remove() {
        throw new UnsupportedOperationException("Method remove does not support.");
    }

    /**
     * Метод forEachRemaining не реализую, поэтому прокидываю исключение UnsupportedOperationException.
     */
    @Override
    public void forEachRemaining(Consumer action) {
        throw new UnsupportedOperationException("Method forEachRemaining does not support.");
    }
}
