package ru.job4j.chessboard;

/**
 * Исключение - наше собственноручно созданное.
 * Возникает, когда фигуры не оказалось в заданной ячейке.
 */
public class FigureNotFoundException extends RuntimeException {
    public FigureNotFoundException(String msg) {
        super(msg);
    }
}
