package ru.job4j.tictactoe;

/**
 * Класс Logic3T - проверка логики.
 */
public class Logic3T {

    private final Figure3T[][] table;
    private static final int START = 1;

    /**
     * Конструктор экземпляра класса Logic3T
     * @param table - двумерный массив из переменых типа Figure3T
     */
    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    /**
     * Метод проверяет победу крестиков.
     * @return - Истина - победили крестики.
     */
    public boolean isWinnerX() {
        return isWinnerRecursion(true);
    }

    /**
     * Метод проверяет победу ноликов.
     * @return - Истина - победили нолики.
     */
    public boolean isWinnerO() {
        return isWinnerRecursion(false);
    }

    /**
     * Метод проверяет, если ли пустые клетки для новых ходов.
     * @return - Истина - есть пустые клетки для новых ходов.
     */
    public boolean hasGap() {
        boolean result = false;
        for (int i = 0; i < this.table.length; i++) {
            for (int j = 0; j < this.table.length; j++) {
                if (!this.table[i][j].hasMarkX() && !this.table[i][j].hasMarkO()) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * Метод isWinnerRecursion проверяет, есть ли победитель по заданной пометке.
     * @param checkMarkX  - если Истина - то проверить пометку крестик, иначе - проверить пометку нолик.
     * @return - возвращает Истину, если есть победитель по заданной пометке.
     */
    private boolean isWinnerRecursion(boolean checkMarkX) {
        boolean isWin = false;
        for (int i = 0; i < this.table.length && !isWin; i++) {
            for (int j = 0; j < this.table.length; j++) {
                if (this.traversal(i, j, START, 0, 1, checkMarkX) || this.traversal(i, j, START, 1, 0, checkMarkX) || this.traversal(i, j, START, 1, 1, checkMarkX) || this.traversal(i, j, START, -1, 1, checkMarkX)) {
                    isWin = true;
                    break;
                }
            }
        }
        return isWin;
    }

    /**
     * Метод рекурсивного поиска совпадающих пометок в заданном направлении.
     * @param x - текущий индекс строки проверяемой ячейки массива.
     * @param y - текущий индекс столбца проверяемой ячейки массива.
     * @param count - шаг рекурсии ( когда count == длине таблицы, тогда есть победитель)
     * @param stepX - направление движения по X.
     * @param stepY - направление движения по Y.
     * @param checkMarkX - Истина = проверка крестиков, Ложь = проверка ноликов.
     * @return - возвращает Истину, если все ячейки строки(или столбца, или диагонали) имеют заданную пометку.
     */
    private boolean traversal(int x, int y, int count, int stepX, int stepY, boolean checkMarkX) {
        boolean result = false;
        if (count == this.table.length) {
            result = true;
        } else {
            if (x + stepX >= 0
                && y + stepY >= 0
                && x + stepX < this.table.length
                && y + stepY < this.table.length
                && hasMark(table[x][y], checkMarkX)
                && hasMark(table[x + stepX][y + stepY], checkMarkX)) {
                result = this.traversal(x + stepX, y + stepY, count + 1, stepX, stepY, checkMarkX);
            }
        }
        return result;
    }

    /**
     * Метод hasMark проверяет, имеет ли ячейка заданную пометку.
     * @param cell - ячейка таблицы
     * @param checkMarkX - если Истина - то проверить крестик, иначе - проверить нолик.
     * @return - возвращает Истину, если ячейка имеет требуемую пометку.
     */
    private boolean hasMark(Figure3T cell, boolean checkMarkX) {
        boolean result = false;
        if (checkMarkX) {
            result = cell.hasMarkX();
        } else {
            result = cell.hasMarkO();
        }
        return result;
    }


}
