package ru.job4j.chessboard;

/**
 * Ячейка шахматной доски.
 * Характеризуется координатами x и y.
 */
public class Cell {
    private int x;
    private int y;

    /**
     * Конструктор ячейки.
     * @param x - координата ячейки по оси x, x изменяется от 1 до конца доски, обычно до 8.
     * @param y - координата ячейки по оси y, y изменяется от 1 до конца доски, обычно до 8.
     */
    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Геттер для x
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     * Геттер для y.
     * @return
     */
    public int getY() {
        return y;
    }

}
