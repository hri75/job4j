package ru.job4j.chessboard;

/**
 * Исключение - наше собственноручно созданное.
 * Возникает, когда путь, по которому фигура будет идти, занят другими фигурами.
 */
public class OccupiedWayException extends RuntimeException {
    public OccupiedWayException(String msg) {
        super(msg);
    }
}


