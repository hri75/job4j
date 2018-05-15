package ru.job4j.sort;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Set;

/**
 * Тестирование класса SortUserTest.
 */
public class SortUserTest {
    @Test
    public void whenUnsorted2UsersThenSorted2UsersByAge() {
        User first = new User("Антон", 50);
        User middle = new User("Филипп", 20);
        User last = new User("Ярослав", 10);
        ArrayList<User> list = new ArrayList<>();
        list.add(first);
        list.add(middle);
        list.add(last);
        Set<User> result = new SortUser().sort(list);
        User[] array = new User[3];
        result.toArray(array);
        assertThat(array[0].getAge(), is(last.getAge()));
    }
}
