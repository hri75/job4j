package ru.job4j.map;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 * 5. Перекрывать и equals и hashCode [#1002].
 *
 * Объяснение:
 * В карте 1 запись, потому что user1 и user2 - равны друг другу,
 * у user1 и user2 совпадают хэш-коды и equals == true,
 * поэтому добавление второй записи не происходит, а происходит замена значения у первого ключа.
 *
 * Результат вывода на печать:
 * {ru.job4j.map.User@413e8ccc=Второй}
 * user1.equals(user2)) = true
 * user1.hashCode() = 1094618316, user2.hashCode() = 1094618316
 */
public class LearnOverrideEqualsAndHashcode {
    public static void main(String[] args) {
        User user1 = new User("Иванов", 3, new GregorianCalendar(1980, 0, 15));
        User user2 = new User("Иванов", 3, new GregorianCalendar(1980, 0, 15));
        Map<User, Object> map = new HashMap<>();
        map.put(user1, "Первый");
        map.put(user2, "Второй");
        System.out.println(map);
        System.out.println("user1.equals(user2)) = " + user1.equals(user2));
        System.out.println("user1.hashCode() = " + user1.hashCode() + ", user2.hashCode() = " + user2.hashCode());
    }
}
