package ru.job4j.chessboard;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

/**
 * Тест для класса Queen.
 */
public class QueenTest {
    /**
     * Правильный ход королевы с 8,1 на 2,7. Без других фигур на доске.
     */
    @Test
    public void whenFigureRightMoveWithoutFigures() {
        Cell source = new Cell(8, 1);
        Cell dest = new Cell(2, 7);
        Board board = new Board();
        board.add(new Queen(source));
        boolean result = board.move(source, dest);
        assertThat(true, is(result));
    }

    /**
     * Неправильный ход королевы с 8,1 на 2,2. Без других фигур на доске.
     * Выбрасывается исключение ImpossibleMoveException.
     */
    @Rule
    public ExpectedException impossible = ExpectedException.none();

    @Test
    public void whenFigureWrongMoveWithoutFigures() throws ImpossibleMoveException {

        impossible.expect(ImpossibleMoveException.class);
        impossible.expectMessage("Королева не может так ходить.");

        Cell source = new Cell(8, 1);
        Cell dest = new Cell(2, 2);
        Board board = new Board();
        board.add(new Queen(source));
        boolean result = board.move(source, dest);
        impossible = ExpectedException.none();
    }

    /**
     * Ход королевы с 8,2 на 8,3 на занятую ячейку (с другой фигурой).
     * Выбрасывается исключение OccupiedWayException.
     */
    @Rule
    public ExpectedException occupied = ExpectedException.none();

    @Test
    public void whenFigureWrongMoveOccupiedWayException() throws OccupiedWayException {
        occupied.expect(OccupiedWayException.class);
        occupied.expectMessage("Путь занят.");
        Cell source = new Cell(8, 1);
        Cell dest = new Cell(2, 7);
        Board board = new Board();
        board.add(new Queen(source));
        Cell occup = new Cell(3, 6);
        board.add(new Bishop(occup));
        boolean result = board.move(source, dest);
        occupied = ExpectedException.none();
    }

    /**
     * Неправильно указана исходная ячейка - в ней нет фигуры. Без других фигур на доске.
     * Выбрасывается исключение ImpossibleMoveException.
     */
    @Rule
    public ExpectedException notfound = ExpectedException.none();

    @Test
    public void whenFigureWrongMoveFigureNotFoundException() throws FigureNotFoundException {
        notfound.expect(FigureNotFoundException.class);
        notfound.expectMessage("В ячейке не найдена фигура.");
        Cell source = new Cell(8, 2);
        Cell dest = new Cell(8, 3);
        Board board = new Board();
        board.add(new Queen(source));
        boolean result = board.move(dest, dest);
        notfound = ExpectedException.none();
    }
}

