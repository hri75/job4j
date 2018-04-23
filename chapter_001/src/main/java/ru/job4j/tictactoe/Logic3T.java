package ru.job4j.tictactoe;

/**
 * Класс Logic3T - проверка логики.
 */
public class Logic3T {

    private final Figure3T[][] table;

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
        return isWinner(true);
    }

    /**
     * Метод проверяет победу ноликов.
     * @return - Истина - победили нолики.
     */
    public boolean isWinnerO() {
        return isWinner(false);
    }

    /**
     * Метод проверяет, если ли пустые клетки для новых ходов.
     * @return - Истина - есть пустые клетки для новых ходов.
     */
    public boolean hasGap() {
        boolean result = false;
        //а если массив неровный?
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                if (!table[i][j].hasMarkX() && !table[i][j].hasMarkO()) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * Метод isWinner проверяет, есть ли победитель по заданной пометке.
     * @param checkMarkX  - если Истина - то проверить пометку крестик, иначе - проверить пометку нолик.
     * @return - возвращает Истину, если есть победитель по заданной пометке.
     */
    private boolean isWinner(boolean checkMarkX) {
        boolean isWin = false; //есть ли победитель

        //проверим по строкам - нет ли строки с заполненными крестиками
        for (int i = 0; i < table.length && !isWin; i++) {
            isWin = true;
            for (int j = 0; j < table.length; j++) {
                if (!hasMark(table[i][j], checkMarkX)) {
                    isWin = false;
                    break;
                }
            }
        }
        //проверим по столбцам - нет ли столбца с заполненными крестиками
        if (!isWin) {
            for (int i = 0; i < table.length && !isWin; i++) {
                isWin = true;
                for (int j = 0; j < table.length; j++) {
                    if (!hasMark(table[j][i], checkMarkX)) {
                        isWin = false;
                        break;
                    }
                }
            }
        }
        //проверим по 1-й диагонали:
        if (!isWin) {
            isWin = true;
            for (int i = 0; i < table.length; i++) {
                if (!hasMark(table[i][i], checkMarkX)) {
                    isWin = false;
                    break;
                }
            }
        }
        //проверим по 2-й диагонали:
        if (!isWin) {
            isWin = true;
            for (int i = 0; i < table.length; i++) {
                if (!hasMark(table[table.length - i - 1][i], checkMarkX)) {
                    isWin = false;
                    break;
                }
            }
        }

        return isWin;
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
