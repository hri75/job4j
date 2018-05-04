package ru.job4j.chessboard;

/**
 * Исключение - наше собственноручно созданное.
 * Возникает, когда фигура не может пойти в заданную ячейку.
 */
public class FigureNotFoundException extends RuntimeException {
    public FigureNotFoundException(String msg) {
        super(msg);
    }
}
