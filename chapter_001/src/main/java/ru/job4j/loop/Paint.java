package ru.job4j.loop;

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
        // Буфер для результата.
        StringBuilder screen = new StringBuilder();
        // ширина будет равна высоте.
        int weight = 2 * height - 1;
        // внешний цикл двигается по строкам.
        for (int row = 0; row != height; row++) {
            // внутренний цикл определяет положение ячейки в строке.
            for (int column = 0; column != weight; column++) {
                // если строка равна ячейки, то рисуем галку.
                // в данном случае строка определяем, сколько галок будет на строке
                if (column >= height - row - 1 && column <= height + row - 1) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            // добавляем перевод строки.
            screen.append(System.lineSeparator());
        }
        // Получаем результат.
        return screen.toString();
    }
}


