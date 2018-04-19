package ru.job4j.loop;

/**
 * Class Board - шахматная доска в псевдографике.
 */
public class Board {
    /**
     * Метод создает строку, содержащую доску в псевдографике.
     * @param width - ширина доски.
     * @param height - высота доски.
     * @return строка, содержащая доску (с разделителями строк).
     */
    public String paint(int width, int height) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                // условие проверки, что писать пробел или X
                // Выше в задании мы определили закономерность, когда нужно проставлять X
                if ((i + j) % 2 == 0) {
                    screen.append("X");
                } else {
                    screen.append(" ");
                }
            }
            // добавляем перевод на новую строку.
            screen.append(ln);
        }
        return screen.toString();
    }
}
