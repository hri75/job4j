package ru.job4j.map;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Объяснение:
 * В карту добавились 2 записи, потому что ключи user1 и user2 - в данном случае не равны друг другу,
 * хотя hashcode для двух объектов совпадают, но этого мало, чтобы признать ключи равными друг другу!
 * метод equals  по-умолчанию для двух объектов
 * даст Ложь  (пример кода:
 *    public boolean equals(Object obj) {
 *        return (this == obj);
 *   }
 *
 * Соответственно, для разных ключей - две записи в map.
 *
 * Результат вывода на печать: {ru.job4j.map.User@413f012b=Первый, ru.job4j.map.User@413f012b=Второй}
 */
public class LearnOverrideHashcode {
    public static void main(String[] args) {
        User user1 = new User("Иванов", 3, new GregorianCalendar(1980, 0, 15));
        User user2 = new User("Иванов", 3, new GregorianCalendar(1980, 0, 15));
        Map<User, Object> map = new HashMap<>();
        map.put(user1, "Первый");
        map.put(user2, "Второй");
        System.out.println(map);
    }
}
