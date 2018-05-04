package ru.job4j.chessboard;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Rule;
import org.junit.rules.ExpectedException;

/**
 * Тест для класса Board.
 */
public class BoardTest {
    /**
     * Правильный ход слона с 8,1 на 2,7. Без других фигур на доске.
     */
    @Test
    public void whenBishopRightMoveWithoutFigures() {
        Cell source = new Cell(8, 1);
        Cell dest = new Cell(2, 7);
        Bishop bishop = new Bishop(source);
        Board board = new Board();
        board.add(bishop);
        boolean result = board.move(source, dest);
        assertThat(true, is(result));
    }

    /**
     * Неправильный ход слона с 8,1 на 8,8. Без других фигур на доске.
     * Выбрасывается исключение ImpossibleMoveException.
     */
    @Rule
    public ExpectedException impossible = ExpectedException.none();

    @Test
    public void whenBishopWrongMoveWithoutFigures() throws ImpossibleMoveException {

        impossible.expect(ImpossibleMoveException.class);
        impossible.expectMessage("Слон не может так ходить.");

        Cell source = new Cell(8, 1);
        Cell dest = new Cell(8, 8);
        Bishop bishop = new Bishop(source);
        Board board = new Board();
        board.add(bishop);
        boolean result = board.move(source, dest);
        impossible = ExpectedException.none();
    }

    /**
     * Ход слона с 8,1 на 2,7 через занятую ячейку (с другой фигурой).
     * Выбрасывается исключение OccupiedWayException.
     */
    @Rule
    public ExpectedException occupied = ExpectedException.none();

    @Test
    public void whenBishopWrongMoveOccupiedWayException() throws OccupiedWayException {
        occupied.expect(OccupiedWayException.class);
        occupied.expectMessage("Путь занят.");
        Cell source = new Cell(8, 1);
        Cell dest = new Cell(2, 7);
        Bishop bishop = new Bishop(source);
        Board board = new Board();
        board.add(bishop);
        Cell occup = new Cell(6, 3);
        Bishop another = new Bishop(occup);
        board.add(another);
        boolean result = board.move(source, dest);
        occupied = ExpectedException.none();
    }

    /**
     * Неправильно указана исходная ячейка - в ней нет слона. Без других фигур на доске.
     * Выбрасывается исключение ImpossibleMoveException.
     */
    @Rule
    public ExpectedException notfound = ExpectedException.none();

    @Test
    public void whenBishopWrongMoveFigureNotFoundException() throws FigureNotFoundException {
        notfound.expect(FigureNotFoundException.class);
        notfound.expectMessage("В ячейке не найдена фигура.");
        Cell source = new Cell(8, 1);
        Cell dest = new Cell(8, 8);
        Bishop bishop = new Bishop(source);
        Board board = new Board();
        board.add(bishop);
        boolean result = board.move(dest, dest);
        notfound = ExpectedException.none();
    }
}
