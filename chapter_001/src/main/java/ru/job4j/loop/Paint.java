package ru.job4j.loop;

import java.util.function.BiPredicate;

/**
 * Class Paint - рисуем пирамиду в псевдографике.
 */

public class Paint {
    /**
     * Метод, "рисующий" пирамиду в псевдографике.
     * @param height - высота пирамиды.
     * @return - строка, содержащая пирамиду (с разделителями строк).
     */
    public String pyramid(int height) {
        return this.loopBy(
                height,
                2 * height - 1,
                (row, column) -> column >= height - row - 1 && column <= height + row - 1
        );
    }

    /**
     * Правая половинка пирамиды.
     * @param height - высота пирамиды
     * @return - строка, содержащая правую половинку пирамиды.
     */
    public String rightTrl(int height) {
        return this.loopBy(
                height,
                height,
                (row, column) -> row >= column
        );
    }

    /**
     * Левая половинка пирамиды.
     * @param height - высота пирамиды.
     * @return - строка, содержащая левую половинку пирамиды.
     */
    public String leftTrl(int height) {
        return this.loopBy(
                height,
                height,
                (row, column) -> row >= height - column - 1
        );
    }

    /**
     * Универсальная функция.
     * @param height
     * @param weight
     * @param predict
     * @return
     */
    private String loopBy(int height, int weight, BiPredicate<Integer, Integer> predict) {
        StringBuilder screen = new StringBuilder();
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != weight; column++) {
                if (predict.test(row, column)) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }
}


