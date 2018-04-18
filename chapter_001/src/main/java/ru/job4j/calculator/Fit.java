package ru.job4j.calculator;

/**
 * Class Fit - вычисляет иддеальный вес для мужчин и женщин.
 */
public class Fit {

    /**
     * Идеальный вес для мужщины.
     * @param height Рост в сантиметрах.
     * @return идеальный вес в килограммах.
     */
    public double manWeight(double height) {
        return (height - 100D) * 1.15;
    }

    /**
     * Идеальный вес для женщины.
     * @param height Рост в сантиметрах.
     * @return идеальный вес в килограммах.
     */
    public double womanWeight(double height) {
        return (height - 110D) * 1.15;
    }
}
