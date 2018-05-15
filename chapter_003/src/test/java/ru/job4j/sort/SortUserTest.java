package ru.job4j.sort;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Set;
import java.util.List;

/**
 * Тестирование класса SortUserTest.
 */
public class SortUserTest {
    /**
     * Тест реализации интерфейса Comparable у класса User.
     */
    @Test
    public void whenUnsorted3UsersThenSorted3UsersByAge() {
        User first = new User("Антон", 50);
        User middle = new User("Филипп", 20);
        User last = new User("Ярослав", 10);
        List<User> list = Arrays.asList(first, middle, last);
        List<User> sortedList = Arrays.asList(last, middle, first);
        Set<User> set = new SortUser().sort(list);
        User[] expected = new User[3];
        User[] result = new User[3];
        set.toArray(result);
        sortedList.toArray(expected);
        assertThat(result, is(expected));
    }

    /**
     * Тест сортировки по длине имени.
     */
    @Test
    public void whenSortedByNameLength() {
        User first = new User("Иннокентий", 50);
        User middle = new User("Филипп", 20);
        User last = new User("Антон", 10);
        List<User> expected = Arrays.asList(last, middle, first);
        List<User> result = Arrays.asList(first, middle, last);
        new SortUser().sortNameLength(result);
        assertThat(result, is(expected));
    }
    /**
     * Тест сортировки по всем полям - сначала по имени, потом по возрасту, если по имени оказались равны.
     */
    @Test
    public void whenSortedByAllFieds() {
        User first = new User("Сергей", 25);
        User second = new User("Иван", 30);
        User third = new User("Сергей", 20);
        User fourth = new User("Иван", 25);
        List<User> expected = Arrays.asList(fourth, second, third, first);
        List<User> result = Arrays.asList(first, second, third, fourth);
        new SortUser().sortByAllFields(result);
        assertThat(result, is(expected));
    }
}
