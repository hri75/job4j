package ru.job4j.map;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 * 4. Переопределить только equals [#1004]
 *
 * Объяснение:
 * В карту добавились 2 записи, потому что хэш-код user1 и хэш-код user2 - не равны друг другу,
 * а при добавлении методом put первая часть условия требует, чтобы хэш-коды совпадали:
 * Пример:
 * if (p.hash == hash && ((k = p.key) == key || (key != null && key.equals(k))))
 *
 * хэши не равны, условие не выполняется, делается две записи в map. На equals даже не смотрим!
 *
 * Результат вывода на печать:
 * {ru.job4j.map.User@7ea987ac=Второй, ru.job4j.map.User@4b67cf4d=Первый}
 * user1.equals(user2)) = true
 */
public class LearnOverrideEquals {
    public static void main(String[] args) {
        User user1 = new User("Иванов", 3, new GregorianCalendar(1980, 0, 15));
        User user2 = new User("Иванов", 3, new GregorianCalendar(1980, 0, 15));
        Map<User, Object> map = new HashMap<>();
        map.put(user1, "Первый");
        map.put(user2, "Второй");
        System.out.println(map);
        System.out.println("user1.equals(user2)) = " + user1.equals(user2));
    }
}
