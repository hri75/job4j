package ru.job4j.generic;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;

/**
 * Тест для класса UserStore.
 */
public class UserStoreTest {

    private UserStore userStore;

    @Before
    public void setUp() {
        userStore = new UserStore(10);
    }
    @Test
    public void whenIdIsNull() {
        User expected = new User(null);
        User user2 = new User(null);
        userStore.add(expected);
        userStore.add(user2);
        User result = userStore.findById(null);
        assertThat(result == expected, is(true));
    }

    @Test
    public void whenFindById() {
        User user1 = new User("AAA");
        User expected = new User("BBB");
        User user2 = new User("CCC");
        userStore.add(user1);
        userStore.add(expected);
        userStore.add(user2);
        User result = userStore.findById("BBB");
        assertThat(result.getId().equals("BBB"), is(true));
    }

    @Test
    public void whenReplace() {
        User user1 = new User("AAA");
        User user2 = new User("BBB");
        User user3 = new User("CCC");
        userStore.add(user1);
        userStore.add(user2);
        userStore.add(user3);
        assertThat(userStore.replace("BBB", user3), is(true));
        assertThat(userStore.replace("BBB", user3), is(false));
    }

    @Test
    public void whenDelete() {
        User user1 = new User("AAA");
        User user2 = new User("BBB");
        User user3 = new User("CCC");
        userStore.add(user1);
        userStore.add(user2);
        userStore.add(user3);
        assertThat(userStore.delete("AAA"), is(true));
        assertThat(userStore.delete("BBB"), is(true));
        assertThat(userStore.findById("AAA"), is(nullValue()));
    }

    @Test
    public void findById() {
        User user1 = new User("AAA");
        User user2 = new User("AAA");
        User user3 = new User("AAA");
        userStore.add(user1);
        userStore.add(user2);
        userStore.add(user3);
        assertThat(userStore.findById("AAA") == user1, is(true));
    }
}