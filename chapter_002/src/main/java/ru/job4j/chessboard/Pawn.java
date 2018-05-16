package ru.job4j.chessboard;

import java.util.Arrays;

/**
 * класс, описывающий фигуру "Пешка".
 */
public class Pawn extends Figure {
    /**
     * Конструктор фигуры "Пешка".
     * @param position - позиция фигуры (тип Cell).
     */
    public Pawn(Cell position) {
        super(position);
    }

    /**
     * Сходить фигурой.
     * Метод должен работать так.
     * dest - задает ячейку, куда следует пойти. Если фигура может туда пойти. то Вернуть массив ячеек. которые должна пройти фигура.
     * Если фигура туда пойти не может. выбросить исключение ImposibleMoveException
     *
     * @param source - исходная ячейка, в которой стоит фигура.
     * @param dest - ячейка, куда следует пойти.
     * @return - возвращает массив ячеек, которые должна пройти фигура. Ячейка source в этот массив не включается,
     * так как фигура уже стоит в этой ячейке. Ячейка dest - включается.
     * @throws ImpossibleMoveException - исключение, выбрасываемое, если фигура не может пойти в ячейку dest.
     *
     * Примечание: Пешка ходит на одну ячейку, поэтому следующая ячейка, куда делает ход пешка, отличается от предыдущей
     * на dy = +1 или dy = -1.
     * переменные x,y = текущие координаты, через которые проходит пешка.
     * Если фигура вышла за границы доски - значит надо выбросить исключение ImpossibleMoveException.
     * Диапазон допустимых значений x и y = от 1 до SIZE. (для обычной доски SIZE = 8).
     */
    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        String exceptionMessage = "Пешка не может так ходить.";
        Cell[] temp = new Cell[SIZE - 1];
        int pos = 0;
        int x = source.getX();
        int y = source.getY();
        int dx = Integer.compare(dest.getX(), source.getX());
        int dy = Integer.compare(dest.getY(), source.getY());
        if (dx != 0 || dy <= 0) {
            throw new ImpossibleMoveException(exceptionMessage);
        }
        x += dx;
        y += dy;
        if (x < 1 || x > SIZE || y < 1 || y > SIZE) {
            throw new ImpossibleMoveException(exceptionMessage);
        }
        temp[pos++] = new Cell(x, y);
        if (x != dest.getX() || y != dest.getY()) {
            throw new ImpossibleMoveException(exceptionMessage);
        }
        return Arrays.copyOf(temp, pos);
    }


    /**
     * Метод создает новую фигуру с указанной координатой.
     * @param dest - координата фигуры.
     * @return
     */
    @Override
    public Figure copy(Cell dest) {
        return new Pawn(dest);
    }
}
