package ru.job4j.tracker;

import java.util.Random;

/**
 * Хранилище для заявок, обертка над массивом заявок.
 */
public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private Item[] items = new Item[100];

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

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
        this.items[this.position++] = item;
        return item;
    }

    /**
     * Метод заменяет заявку на новую заявку.
     * @param id - id заменяемой заявки.
     * @param item - новая заявка.
     */
    public void replace(String id, Item item) {
        if (id != null) {
            for (int i = 0; i < position; i++) {
                if (id.equals(this.items[i].getId())) {
                    item.setId(id);
                    this.items[i] = item;
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
            for (int i = 0; i < position; i++) {
                if (id.equals(this.items[i].getId())) {
                    System.arraycopy(this.items, i + 1, this.items, i, position - i - 1);
                    this.items[--position] = null;
                    break;
                }
            }
        }
    }

    /**
     * Метод возвращает копию массива this.items без null элементов.
     * @return - массив items без null-элементов.
     */
    public Item[] findAll() {
        Item[] result = null;
        if (position > 0) {
            result = new Item[position];
            System.arraycopy(this.items, 0, result, 0, position);
        }
        return result;
    }

    /**
     * Метод ищет все заявки, у которых имя заявки равно искомому имени.
     * @param key - искомое имя.
     * @return - массив заявок, у которых имя заявки равно искомому имени. Если ничего не найдено - возвращается null.
     * Примечание: в метод может быть передан null - тогда вернется null.
     * Может быть так, что все 100 заявок в массиве items имеют искомое имя.
     */
    public Item[] findByName(String key) {
        Item[] result = null;
        if (key != null) {
            Item[] temp = new Item[100];
            int index = 0;
            for (int i = 0; i < position; i++) {
                if (key.equals(this.items[i].getName())) {
                    temp[index++] = this.items[i];
                }
            }
            if (index > 0) {
                result = new Item[index];
                System.arraycopy(temp, 0, result, 0, index);
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
            for (int i = 0; i < position; i++) {
                if (id.equals(this.items[i].getId())) {
                    result = this.items[i];
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
     * @return - строка с ирнформацией по заявке.
     */
    public String getItemInfo(Item item) {
        return new StringBuilder().append(item.getName()).append(", ").append(item.getDesc()).append(", id = ").append(item.getId()).toString();
    }

}
