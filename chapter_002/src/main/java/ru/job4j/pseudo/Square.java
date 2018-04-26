package ru.job4j.pseudo;

/**
 * Квадрат.
 */
public class Square implements Shape {
    /**
     * Возвращает квадрат в псевдографике
     * @return - строка с квадратом в псевдографике.
     */

    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("****\n");
        pic.append("*  *\n");
        pic.append("*  *\n");
        pic.append("****");
        return pic.toString();
    }
}
