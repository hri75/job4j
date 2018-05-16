package ru.job4j.chessboard;

import java.util.Arrays;

/**
 * класс, описывающий фигуру "Конь".
 */
public class Knight extends Figure {
    /**
     * Конструктор фигуры "Конь".
     * @param position - позиция фигуры (тип Cell).
     */
    public Knight(Cell position) {
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
     * Примечание: Конь ходит буквой Г.
     * dx и dy при ходе конем не могут быть равны друг другу, должно быть например, dx = 1 и dy = 2
     * переменные x,y = текущие координаты, через которые проходит фигура.
     * Если фигура вышла за границы доски - значит надо выбросить исключение ImpossibleMoveException.
     * Диапазон допустимых значений x и y = от 1 до SIZE. (для обычной доски SIZE = 8).
     */
    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        String exceptionMessage = "Конь не может так ходить.";
        Cell[] temp = new Cell[SIZE - 1];
        int pos = 0;
        int x = source.getX();
        int y = source.getY();
        int dx = dest.getX() - source.getX();
        int dy = dest.getY() - source.getY();
        int absDx = Math.abs(dx);
        int absYx = Math.abs(dy);
        if (!(absDx != absYx && ((absDx == 1 && absYx == 2) || (absDx == 2 && absYx == 1)))) {
            throw new ImpossibleMoveException(exceptionMessage);
        }
        do {
            x += dx;
            y += dy;
            if (x < 1 || x > SIZE || y < 1 || y > SIZE) {
                throw new ImpossibleMoveException(exceptionMessage);
            }
            temp[pos++] = new Cell(x, y);
        }
        while (x != dest.getX() || y != dest.getY());
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
