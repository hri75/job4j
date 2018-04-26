package ru.job4j.pseudo;

/**
 * Треугольник.
 */
public class Triangle implements Shape {

    /**
     * Возвращает треугольник в псевдографике
     * @return - строка с треугольником в псевдографике.
     */
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("  *\n");
        pic.append(" * *\n");
        pic.append("*****");
        return pic.toString();
    }
}
