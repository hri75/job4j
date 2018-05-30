package ru.job4j.tree;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * @author Rustam Harisov <hri75@mail.ru>
 * @since 30.05.2018
 */

/**
 * Тест для класса BinarySearchTree.
 */
public class BinarySearchTreeTest {

    private BinarySearchTree<Integer> bst;

    @Before
    public void setUp() {
        bst = new BinarySearchTree<>(5);
    }

    @Test
    public void whenAddAndIterate() {
        bst.add(4);
        bst.add(6);
        bst.add(5);
        bst.add(4);
        bst.add(10);
        bst.add(9);
        Iterator<Integer> iterator = bst.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(5));
        assertThat(iterator.next(), is(4));
        assertThat(iterator.next(), is(6));
        assertThat(iterator.next(), is(4));
        assertThat(iterator.next(), is(5));
        assertThat(iterator.next(), is(10));
        assertThat(iterator.next(), is(9));
    }
}