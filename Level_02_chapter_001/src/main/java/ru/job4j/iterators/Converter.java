package ru.job4j.iterators;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Класс "Конвертер".
 *
 * Примечание: в задании не сказано, может ли быть один из итераторов ПУСТЫМ. Предложенный файл с тестами
 * "пустой" итератор среди нескольких итераторов не отлавливает.
 */
public class Converter {

    /**
     * Инициализирую итератором, не содержащим последовательности, пригодится, если передадут пустой итератор итераторов.
     */
    private Iterator<Integer> currentIterator = new ArrayList<Integer>().iterator();

    /**
     * Метод конвертирует Итератор итераторов в Итератор чисел.
     * @param it - итератор итераторов.
     * @return - итератор чисел.
     */
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        if (it.hasNext()) {
            currentIterator = it.next();
        }
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                setIteratorPointer();
                return currentIterator.hasNext();
            }

            @Override
            public Integer next() {
                setIteratorPointer();
                return currentIterator.next();
            }

            /**
             * Метод пытается установить указатель итератора на позицию, где есть число, а если нет чисел, то дойдет до конца.
              */
            private void setIteratorPointer() {
                while (!currentIterator.hasNext() && it.hasNext()) {
                    currentIterator = it.next();
                }
            }
        };
    }
}
