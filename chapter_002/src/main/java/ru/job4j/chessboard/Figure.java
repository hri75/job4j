package ru.job4j.chessboard;

/**
 * Абстрактный класс "Фигура"
 */
public abstract class Figure {
    /**
     * Размер шахматной доски (8 х 8).
     */
    public static final int SIZE = 8;

    /**
     * Координата фигуры.
     */
    final Cell position;

    /**
     * Конструктор.
     * @param position - ячейка, куда помещается фигура на шахматной доске.
     */
    public Figure(Cell position) {
        this.position = position;
    }

    /**
     * Сходить фигурой.
     * Метод должен работать так.
     * dest - задает ячейку, куда следует пойти. Если фигура может туда пойти. то Вернуть массив ячеек. которые должна пройти фигура.
     * Если фигура туда пойти не может. выбросить исключение ImposibleMoveException
     * @param source - исходная ячейка.
     * @param dest - задает ячейку, куда следует пойти.
     * @return - возвращает массив ячеек, которые должна пройти фигура. Ячейка source в этот массив не включается,
     * так как фигура уже стоит в этой ячейке. Ячейка dest - включается.
     * @throws ImpossibleMoveException
     */
    public abstract Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException;

    /**
     * Пересоздать фигуру с новой координатой.
     * @param dest - координата фигуры.
     * @return - фигура.
     */
    public abstract Figure copy(Cell dest);
}
