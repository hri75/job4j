package ru.job4j.sort;

import java.util.*;

/**
 * Сортировщик.
 */
public class SortUser {
    /**
     * Метод сортирует переданный список пользователей по Возрасту.
     * @param list - переданный список пользователей.
     * @return - отсортированное множество.
     */
    public Set<User> sort(List<User> list) {
        TreeSet<User> result = new TreeSet<>();
        result.addAll(list);
        return result;
    }
}
