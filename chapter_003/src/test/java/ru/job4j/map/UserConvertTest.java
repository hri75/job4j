package ru.job4j.map;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест класса UserConvert.
 */
public class UserConvertTest {
    @Test
    public void whenConvertListToMap() {
        User user1 = new User(1, "John", "New York");
        User user2 = new User(2, "Ivan", "Moscow");
        List<User> list = Arrays.asList(user1, user2);
        UserConvert converter = new UserConvert();
        HashMap<Integer, User> result = converter.process(list);
        HashMap<Integer, User> expected = new HashMap<>();
        expected.put(1, user1);
        expected.put(2, user2);
        assertThat(result, is(expected));
    }
}
