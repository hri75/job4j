package ru.job4j.bank;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест для класса User.
 */
public class UserTest {
    /**
     * Поля полностью совпадают.
     */
    @Test
    public void whenEqualsByFields() {
        User user1 = new User("Иванов", "паспорт");
        User user2 = new User("Иванов", "паспорт");
        assertThat(user1.equals(user2), is(true));
    }

    /**
     * Несовпадающие поля.
     */
    @Test
    public void whenNotEqualsByFields() {
        User user1 = new User("Иванов", "паспорт");
        User user2 = new User("Иванов", "удостоверение");
        assertThat(user1.equals(user2), is(false));
    }

    /**
     * Другой тип передаю.
     */
    @Test
    public void whenAnotherType() {
        User user1 = new User("Иванов", "паспорт");
        assertThat(user1.equals(new Object()), is(false));
    }
    /**
     * null передаю.
     */
    @Test
    public void whenNull() {
        User user1 = new User("Иванов", "паспорт");
        assertThat(user1.equals(null), is(false));
    }
}
