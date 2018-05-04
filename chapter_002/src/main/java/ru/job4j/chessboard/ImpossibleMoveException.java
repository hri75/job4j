package ru.job4j.chessboard;

/**
 * Исключение - наше собственноручно созданное.
 * Возникает, когда фигура не может пойти в заданную ячейку.
 */
public class ImpossibleMoveException extends RuntimeException {
    public ImpossibleMoveException(String msg) {
        super(msg);
    }
}
