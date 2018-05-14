package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Random;

/**
 * Хранилище для заявок, обертка над массивом заявок.
 */
public class Tracker {
    /**
     * Список для хранение заявок.
     */
    ArrayList<Item> items = new ArrayList<>();

    /**
     * Генератор случайных чисел.
     */
    private static final Random RN = new Random();

    /**
     * Метод, реализующий добавление заявки в хранилище.
     * @param item - добавляемая заявка.
     * @return item - возвращает item, у которого заполнен id
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        //this.items[this.position++] = item;
        this.items.add(item);
        return item;
    }

    /**
     * Метод заменяет заявку на новую заявку.
     * @param id - id заменяемой заявки.
     * @param item - новая заявка.
     */
    public void replace(String id, Item item) {
        if (id != null) {
            for (int i = 0; i < items.size(); i++) {
                if (id.equals(this.items.get(i).getId())) {
                    item.setId(id);
                    this.items.set(i, item);
                    break;
                }
            }
        }
    }

    /**
     * Удаляет элемент, найденный по id и сдвигает на его место на одну ячейку влево оставшиеся элементы.
     * @param id - id удаляемой заявки.
     */
    public void delete(String id) {
        if (id != null) {
            for (int i = 0; i < items.size(); i++) {
                if (id.equals(this.items.get(i).getId())) {
                    this.items.remove(i);
                    break;
                }
            }
        }
    }

    /**
     * Метод возвращает копию списка this.items.
     * @return - список items.
     */
    public ArrayList<Item> findAll() {
        ArrayList<Item> result = new ArrayList<>();
        result.addAll(items);
        return result;
    }

    /**
     * Метод ищет все заявки, у которых имя заявки равно искомому имени.
     * @param key - искомое имя.
     * @return - массив заявок, у которых имя заявки равно искомому имени. Если ничего не найдено - возвращается null.
     * Примечание: в метод может быть передан null - тогда вернется null.
     * Может быть так, что все 100 заявок в массиве items имеют искомое имя.
     */
    public ArrayList<Item> findByName(String key) {
        ArrayList<Item> result = new ArrayList<>();
        if (key != null) {
            for (int i = 0; i < items.size(); i++) {
                if (key.equals(this.items.get(i).getName())) {
                    result.add(this.items.get(i));
                }
            }
        }
        return result;
    }

    /**
     * Метод ищет заявку по id
     * @param id - id заявки.
     * @return - возвращает найденный Item. Если Item не найден - возвращает null.
     */
    public Item findById(String id) {
        Item result = null;
        if (id != null) {
            for (int i = 0; i < items.size(); i++) {
                if (id.equals(this.items.get(i).getId())) {
                    result = this.items.get(i);
                    break;
                }
            }
        }
        return result;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    /**
     * Получает информацию по заявке:  ИмяЗаявки, ОписаниеЗаявки, id = ИдентификаторЗаявки.
     * @param item - заявка.
     * @return - строка с информацией по заявке.
     */
    public String getItemInfo(Item item) {
        return new StringBuilder().append(item.getName()).append(", ").append(item.getDesc()).append(", id = ").append(item.getId()).toString();
    }
}
