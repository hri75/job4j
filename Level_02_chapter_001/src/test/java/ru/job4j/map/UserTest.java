package ru.job4j.map;

import org.junit.Test;

import java.util.GregorianCalendar;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void testEquals() {
        User user1 = new User("Иванов", 3, new GregorianCalendar(1980, 0, 15));
        User user2 = new User("Иванов", 3, new GregorianCalendar(1980, 0, 15));
        User user3 = new User("Иванов И.И.", 3, new GregorianCalendar(1980, 0, 15));
        assertThat(user1.equals(user2), is(true));
        assertThat(user1.equals(user3), is(false));
    }

    @Test
    public void testHashcode() {
        User user1 = new User("Иванов", 3, new GregorianCalendar(1980, 0, 15));
        User user2 = new User("Иванов", 3, new GregorianCalendar(1980, 0, 15));
        User user3 = new User("Иванов И.И.", 3, new GregorianCalendar(1980, 0, 15));
        assertThat(user1.hashCode() == user2.hashCode(), is(true));
        assertThat(user1.hashCode() == user3.hashCode(), is(false));
    }
}