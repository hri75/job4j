package ru.job4j.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Итератор для двумерного целочисленного массива.
 */
public class IteratorArray implements Iterator {

    private final int[][] values;
    private int firstIndex = 0;
    private int secondIndex = 0;

    /**
     * Конструктор.
     * @param values - двумерный целочисленный массив.
     */
    public IteratorArray(int[][] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        return firstIndex < values.length && secondIndex < values[firstIndex].length;
    }

    @Override
    public Object next() {
        int result = 0;
        try {
            result = values[firstIndex][secondIndex];
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
        if (++secondIndex >= values[firstIndex].length) {
            firstIndex++;
            secondIndex = 0;
        }
    }
}
