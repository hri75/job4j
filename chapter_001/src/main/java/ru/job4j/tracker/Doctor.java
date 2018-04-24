package ru.job4j.tracker;

/**
 * Класс Доктор. Является потомком от класса Профессия.
 */
public class Doctor extends Profession {
    /**
     * Метод "Лечить". Лечит пациента.
     * @param patient - пациент, которого надо вылечить.
     * @return - диагноз.
     */
    public Diagnose heal(Patient patient) {
        return null;
    }
}
