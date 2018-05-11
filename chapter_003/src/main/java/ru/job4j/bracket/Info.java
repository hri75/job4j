package ru.job4j.bracket;

import java.util.ArrayList;

public class Info {
    /**
     * Валидная ли переданная строка.
     */
    private boolean valid;

    /**
     * Список из всех пар скобок с позициями открывающей и закрывающей.
     */
    private ArrayList<Item> items;

    /**
     * Конструктор.
     * @param valid - строка правильная.
     * @param items - список скобок с позициями.
     */
    public Info(boolean valid, ArrayList<Item> items) {
        this.valid = valid;
        this.items = items;
    }

    public boolean isValid() {
        return valid;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
}
