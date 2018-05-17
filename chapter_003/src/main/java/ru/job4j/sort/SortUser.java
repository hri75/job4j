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
        return new TreeSet<>(list);
    }

    /**
     * Метод сортирует по длине имени.
     * @param list - список пользователей.
     * @return - отсортированный список пользователей по длине имени.
     */
    public List<User> sortNameLength(List<User> list) {
        list.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return Integer.compare(o1.getName().length(), o2.getName().length());
            }
        });
        return list;
    }

    public List<User> sortByAllFields(List<User> list) {
        list.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                final int rez = o1.getName().compareTo(o2.getName());
                return rez != 0 ? rez : Integer.compare(o1.getAge(), o2.getAge());
            }
        });
        return list;
    }
}
