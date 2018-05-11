package ru.job4j.coffee;

import java.util.ArrayList;

/**
 * Кофе-автомат.
 */
public class Automat {
    /**
     * Метод выдает сдачу монетами.
     * @param value - купюра. Может быть 50, 100 и т.д.
     * @param price - цена кофе.
     * @return - целочисленный массив монет в качестве сдачи.
     */
    public int[] changes(int value, int price) {
        int[] coins = {1, 2, 5, 10};
        ArrayList<Integer> list = new ArrayList<>();
        int remain = value - price;
        int index = coins.length - 1;
        while (remain > 0) {
            while (remain >= coins[index]) {
                list.add(coins[index]);
                remain -= coins[index];
            }
            index--;
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
