package ru.job4j.condition;

/**
 * Class Point - описывает координаты точки на плоскости.
 * @author Harisov Rustam (hri75@mail.ru).
 */
public class Point {
    private int x;
    private int y;

    /**
     * Конструктор экземпляра Paint
     * @param x
     * @param y
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Вычисление расстояния до другой точки
     * @param that - точка типа Point
     * @return расстояние
     */
    public double distanceTo(Point that) {
        return Math.sqrt(Math.pow(this.x - that.x, 2) + Math.pow(this.y - that.y, 2));
    }
}
