package ru.job4j.chessboard;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

/**
 * Тест для класса Knight.
 */
public class KnightTest {
    /**
     * Правильный ход коня с 5,5 на 3,4. Без других фигур на доске.
     */
    @Test
    public void whenFigureRightMoveWithoutFigures() {
        Cell source = new Cell(5, 5);
        Cell dest = new Cell(3, 4);
        Board board = new Board();
        board.add(new Knight(source));
        boolean result = board.move(source, dest);
        assertThat(true, is(result));
    }

    /**
     * Неправильный ход коня с 5,5 на 2,4. Без других фигур на доске.
     * Выбрасывается исключение ImpossibleMoveException.
     */
    @Rule
    public ExpectedException impossible = ExpectedException.none();

    @Test
    public void whenFigureWrongMoveWithoutFigures() throws ImpossibleMoveException {

        impossible.expect(ImpossibleMoveException.class);
        impossible.expectMessage("Конь не может так ходить.");

        Cell source = new Cell(5, 5);
        Cell dest = new Cell(2, 4);
        Board board = new Board();
        board.add(new Knight(source));
        boolean result = board.move(source, dest);
        impossible = ExpectedException.none();
    }

    /**
     * Ход коня с 5,5 на 3,6 на занятую ячейку (с другой фигурой).
     * Выбрасывается исключение OccupiedWayException.
     */
    @Rule
    public ExpectedException occupied = ExpectedException.none();

    @Test
    public void whenFigureWrongMoveOccupiedWayException() throws OccupiedWayException {
        occupied.expect(OccupiedWayException.class);
        occupied.expectMessage("Путь занят.");
        Cell source = new Cell(5, 5);
        Cell dest = new Cell(3, 6);
        Board board = new Board();
        board.add(new Knight(source));
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
        Cell source = new Cell(5, 5);
        Cell dest = new Cell(4, 7);
        Board board = new Board();
        board.add(new Knight(source));
        boolean result = board.move(dest, dest);
        notfound = ExpectedException.none();
    }
}

