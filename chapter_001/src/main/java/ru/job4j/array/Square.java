package ru.job4j.array;

import java.util.Arrays;

/**
 * Класс Square - .
 */
public class Square {
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        for (int i = 0; i < bound; i++) {
            rst[i] = (i+1)*(i+1);
        }
        return rst;
    }
}
