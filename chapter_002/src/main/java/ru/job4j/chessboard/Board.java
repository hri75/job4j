package ru.job4j.chessboard;

/**
 * Шахматная доска.
 */
public class Board {

    /**
     * Максимальное количество фигур на доске.
     */
    private static final int FIG_AMOUNT = 32;

    /**
     * Вспомогательное поле для учета текущего количества фигур.
     */
    private int pos = 0;

    /**
     * Фигуры, находящиеся на доске.
     */
    private Figure[] figures = new Figure[FIG_AMOUNT];

    /**
     * Метод добавляет фигуру на доску.
     * @param figure
     */
    public void add(Figure figure) {
        this.figures[pos++] = figure;
    }

    /**
     * Метод осуществляет ход фигуры по доске.
     * Метод должен проверить:
     * - Что в заданной ячейки есть фигура. если нет. то выкинуть исключение.
     * - Если фигура есть. Проверить может ли она так двигаться. Если нет то упадет исключение.
     * - Проверить что полученный путь. не занят фигурами. Если занят выкинуть исключение.
     * - Если все отлично. Записать в ячейку новое новое положение Figure figure.copy(Cell dest).
     * @param source - исходная ячейка, в которой стоит фигура.
     * @param dest - ячейка, куда следует пойти.
     * @return - булево.
     * @throws ImpossibleMoveException
     * @throws OccupiedWayException
     * @throws FigureNotFoundException
     */
    public boolean move(Cell source, Cell dest) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        int index = this.getIndexOfFigureFromCell(source);
        if (index < 0) {
            throw new FigureNotFoundException("В ячейке не найдена фигура.");
        }
        Cell[] cells = figures[index].way(source, dest);
        for (Cell cell: cells) {
            int another = this.getIndexOfFigureFromCell(cell);
            if (another >= 0) {
                throw new OccupiedWayException("Путь занят.");
            }
        }
        figures[index] = figures[index].copy(dest);
        return true;
    }

    /**
     * Ищет, есть ли на доске фигура с заданной ячейкой.
     * Если есть фигура с заданной ячейкой, то возвращается номер индекса найденной фигуры в массиве фигур.
     * Если фигуры с заданной ячейкой нет, то возвращается -1.
     * @param cell - ячейка.
     * @return - номер индекса найденной фигуры в массиве фигур.
     */
    private int getIndexOfFigureFromCell(Cell cell) {
        int index = -1;
        for (int i = 0; i < this.pos; i++) {
            if (figures[i] != null && figures[i].position.getX() == cell.getX() && figures[i].position.getY() == cell.getY()) {
                index = i;
                break;
            }
        }
        return index;
    }
}
