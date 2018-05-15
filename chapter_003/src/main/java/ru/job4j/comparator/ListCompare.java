package ru.job4j.comparator;

import java.util.Comparator;

/**
 * Сравнитель строк.
 */
public class ListCompare implements Comparator<String> {
    /**
     * Метод сравнивает лексикографически две строки.
     * @param left - строка.
     * @param right - строка.
     * @return - возвращает 0 если строки равны,
     *          меньше нуля если строка left лексикографически меньше, чем строка right,
     *          больше нуля если строка left лексикографически больше, чем строка right.
     */
    @Override
    public int compare(String left, String right) {
        int leftLength = left.length();
        int rightLength = right.length();
        int min = Math.min(leftLength, rightLength);
        int result = 0;
        for (int i = 0; i < min && result == 0; i++) {
            result = Character.compare(left.charAt(i), right.charAt(i));
        }
        if (result == 0) {
            result = Integer.compare(leftLength, rightLength);
        }
        return result;
    }
}
