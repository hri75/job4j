package ru.job4j.map;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Объяснение:
 * В карту добавились 2 записи, потому что ключи user1 и user2 - в данном случае не равны друг другу,
 * так как я не переопределял методы equals и hashcode, а метод equals  по-умолчанию для двух объектов
 * даст Ложь  (пример кода:
 *    public boolean equals(Object obj) {
 *        return (this == obj);
 *   }
 *  и hashcode, скорее всего, тоже даст разные значения. hashcode по-умолчанию - нативный метод,
 *  в описании написано, что этот метод реализован типично как конвертация внутреннего адреса объекта
 *  в число, то есть для разных адресов будет разные значения hashcode.
 *
 * Соответственно, для разных ключей - две записи в map.
 *
 * Результат вывода на печать: {ru.job4j.map.User@7ea987ac=Второй, ru.job4j.map.User@4b67cf4d=Первый}
 */
public class Learn {
    public static void main(String[] args) {
        User user1 = new User("Иванов", 3, new GregorianCalendar(1980, 0, 15));
        User user2 = new User("Иванов", 3, new GregorianCalendar(1980, 0, 15));
        Map<User, Object> map = new HashMap<>();
        map.put(user1, "Первый");
        map.put(user2, "Второй");
        System.out.println(map);
    }
}
