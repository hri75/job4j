package ru.job4j.generic;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;

/**
 * Тест для класса RoleStore.
 */
public class RoleStoreTest {

    private RoleStore roleStore;

    @Before
    public void setUp() {
        roleStore = new RoleStore(10);
    }

    @Test
    public void whenIdIsNull() {
        Role expected = new Role(null);
        Role role2 = new Role(null);
        roleStore.add(expected);
        roleStore.add(role2);
        Role result = roleStore.findById(null);
        assertThat(result == expected, is(true));
    }

    @Test
    public void whenFindById() {
        Role role1 = new Role("AAA");
        Role expected = new Role("BBB");
        Role role2 = new Role("CCC");
        roleStore.add(role1);
        roleStore.add(expected);
        roleStore.add(role2);
        Role result = roleStore.findById("BBB");
        assertThat(result.getId().equals("BBB"), is(true));
    }

    @Test
    public void whenReplace() {
        Role role1 = new Role("AAA");
        Role role2 = new Role("BBB");
        Role role3 = new Role("CCC");
        roleStore.add(role1);
        roleStore.add(role2);
        roleStore.add(role3);
        assertThat(roleStore.replace("BBB", role3), is(true));
        assertThat(roleStore.replace("BBB", role3), is(false));
    }

    @Test
    public void whenDelete() {
        Role role1 = new Role("AAA");
        Role role2 = new Role("BBB");
        Role role3 = new Role("CCC");
        roleStore.add(role1);
        roleStore.add(role2);
        roleStore.add(role3);
        assertThat(roleStore.delete("AAA"), is(true));
        assertThat(roleStore.delete("BBB"), is(true));
        assertThat(roleStore.findById("AAA"), is(nullValue()));
    }

    @Test
    public void findById() {
        Role role1 = new Role("AAA");
        Role role2 = new Role("AAA");
        Role role3 = new Role("AAA");
        roleStore.add(role1);
        roleStore.add(role2);
        roleStore.add(role3);
        assertThat(roleStore.findById("AAA") == role1, is(true));
    }
}