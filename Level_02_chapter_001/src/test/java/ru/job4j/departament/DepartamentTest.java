package ru.job4j.departament;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * @author Rustam Harisov <hri75@mail.ru>
 * @since 30.05.2018
 */
public class DepartamentTest {

    /**
     * Исходный массив строк, здесь пропущены K1, K2, K1\SK1, K2\SK1.
     * */
    private String[] lines = {"K2\\SK1\\SSK2", "K1\\SK2", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2", "K2\\SK1\\SSK1"};

    @Test
    public void whenAscendingSort() {
        Departament departament = new Departament();
        String[] expected = {"K1", "K1\\SK1", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2", "K1\\SK2", "K2", "K2\\SK1", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2"};
        assertThat(departament.sort(lines, true), is(expected));
    }

    @Test
    public void whenDescendingSort() {
        Departament departament = new Departament();
        String[] expected = {"K2", "K2\\SK1", "K2\\SK1\\SSK2", "K2\\SK1\\SSK1", "K1", "K1\\SK2", "K1\\SK1", "K1\\SK1\\SSK2", "K1\\SK1\\SSK1"};
        assertThat(departament.sort(lines, false), is(expected));
    }

}