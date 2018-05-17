package ru.job4j.bank;

/**
 * Счет.
 */
public class Account {
    /**
     * Количество денег на счете.
     */
    private double value;

    /**
     * Реквизиты счета.
     */
    private String requisites;

    public Account(double value, String requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    public double getValue() {
        return value;
    }

    public String getRequisites() {
        return requisites;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
