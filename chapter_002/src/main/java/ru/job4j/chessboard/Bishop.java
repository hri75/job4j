package ru.job4j.chessboard;

import java.util.Arrays;

/**
 * класс, описывающий фигуру "Слон".
 */
public class Bishop extends Figure {
    /**
     * Конструктор фигуры "Слон".
     * @param position - позиция фигуры (тип Cell).
     */
    public Bishop(Cell position) {
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
     * Примечание: Слон ходит по-диагонали, поэтому следующая ячейка, куда делает ход слон, отличается от предыдущей
     * на dx = +1 или dx = -1, и dy = +1 или dy = -1.
     * переменные x,y = текущие координаты, через которые проходит слон.
     * Если слон вышел за границы доски - значит надо выбросить исключение ImpossibleMoveException.
     * Диапазон допустимых значений x и y = от 1 до SIZE. (для обычной доски SIZE = 8).
     */
    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        Cell[] temp = new Cell[SIZE - 1];
        int pos = 0;
        int x = source.getX();
        int y = source.getY();
        int dx = 0;
        int dy = 0;
        if (source.getX() < dest.getX()) {
            dx = 1;
        } else {
            dx = -1;
        }
        if (source.getY() < dest.getY()) {
            dy = 1;
        } else {
            dy = -1;
        }
        do {
            x += dx;
            y += dy;
            if (x < 1 || x > SIZE || y < 1 || y > SIZE) {
                throw new ImpossibleMoveException("Слон не может так ходить.");
            }
            temp[pos++] = new Cell(x, y);
        }
        while (x != dest.getX() || y != dest.getY());
        Cell[] cells = new Cell[pos];
        return Arrays.copyOf(temp, pos);
    }


    /**
     * Метод создает новую фигуру с указанной координатой.
     * @param dest - координата фигуры.
     * @return
     */
    @Override
    public Figure copy(Cell dest) {
        return new Bishop(dest);
    }
}
