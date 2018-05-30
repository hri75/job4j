package ru.job4j.tree;

import org.junit.Test;
import java.util.Iterator;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * @author Rustam Harisov <hri75@mail.ru>
 * @since 29.05.2018
 */

/**
 * Тест для класса Tree.
 */
public class TreeTest {

    @Test
    public void when6ElFindLastThen6() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertThat(
                tree.findBy(6).isPresent(),
                is(true)
        );
    }

    @Test
    public void when6ElFindNotExitThenOptionEmpty() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        assertThat(
                tree.findBy(7).isPresent(),
                is(false)
        );
    }

    @Test
    public void whenAddTheSameValue() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        assertThat(tree.add(4, 3), is(false));
    }

    @Test
    public void whenIterator() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 5);
        tree.add(2, 7);
        tree.add(7, 11);
        tree.add(7, 11);
        tree.add(7, 11);

        Iterator<Integer> iterator = tree.iterator();
        int sum = 0;
        while (iterator.hasNext()) {
            sum += iterator.next();
        }
        assertThat(sum, is(29));
    }

    @Test
    public void whenTreeIsNotBinary() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(2, 4);
        tree.add(2, 5);
        tree.add(3, 6);
        tree.add(3, 7);
        tree.add(3, 8);
        tree.add(6, 9);
        tree.add(6, 9);
        tree.add(6, 9);
        assertThat(tree.isBinary(), is(false));
    }

    @Test
    public void whenTreeIsBinary() {
        Tree<Integer> tree = new Tree<>(1);
        assertThat(tree.isBinary(), is(true));
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(2, 4);
        tree.add(2, 5);
        tree.add(3, 6);
        tree.add(3, 7);
        tree.add(6, 9);
        tree.add(6, 9);
        tree.add(6, 9);
        assertThat(tree.isBinary(), is(true));
    }
}