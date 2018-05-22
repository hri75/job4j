package ru.job4j.iterators;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Тест конвертера итератора итераторов.
 */
public class ConverterIteratorTest {
    /**
     * Должно быть false у пустой последовательности итераторов при вызове .hasNext()
     */
    @Test
    public void whenIteratorIsEmpty() {
        Iterator<Iterator<Integer>> empty = new ArrayList<Iterator<Integer>>().iterator();
        Converter converter = new Converter();
        Iterator<Integer> it = converter.convert(empty);
        assertThat(it.hasNext(), is(false));
    }

    /**
     * Должно вывалиться исключение NoSuchElementException у пустой последовательности итераторов при вызове .next()
     */
    @Test(expected = NoSuchElementException.class)
    public void whenInEmptyIteratorCallNext() {
        Iterator<Iterator<Integer>> empty = new ArrayList<Iterator<Integer>>().iterator();
        Converter converter = new Converter();
        Iterator<Integer> it = converter.convert(empty);
        it.next();
    }

    /**
     * Пустых итераторов добавлю в последовательность итераторов.
     */
    @Test
    public void whenTwoIteratorsEmptyInIterators() {
        Iterator<Integer> it1 = Arrays.asList(1, 2, 3).iterator();
        Iterator<Integer> emptyIterator = new ArrayList<Integer>().iterator();
        Iterator<Integer> it2 = Arrays.asList(4, 5, 6).iterator();
        Iterator<Integer> it3 = Arrays.asList(7, 8, 9).iterator();
        Iterator<Iterator<Integer>> its = Arrays.asList(it1, emptyIterator, it2, emptyIterator, emptyIterator, it3).iterator();
        Converter iteratorOfIterators = new Converter();
        Iterator<Integer> it = iteratorOfIterators.convert(its);
        MatcherAssert.assertThat(it.hasNext(), Matchers.is(true));
        MatcherAssert.assertThat(it.next(), Matchers.is(1));
        MatcherAssert.assertThat(it.hasNext(), Matchers.is(true));
        MatcherAssert.assertThat(it.next(), Matchers.is(2));
        MatcherAssert.assertThat(it.hasNext(), Matchers.is(true));
        MatcherAssert.assertThat(it.next(), Matchers.is(3));
        MatcherAssert.assertThat(it.hasNext(), Matchers.is(true));
        MatcherAssert.assertThat(it.next(), Matchers.is(4));
        MatcherAssert.assertThat(it.hasNext(), Matchers.is(true));
        MatcherAssert.assertThat(it.next(), Matchers.is(5));
        MatcherAssert.assertThat(it.hasNext(), Matchers.is(true));
        MatcherAssert.assertThat(it.next(), Matchers.is(6));
        MatcherAssert.assertThat(it.hasNext(), Matchers.is(true));
        MatcherAssert.assertThat(it.next(), Matchers.is(7));
        MatcherAssert.assertThat(it.hasNext(), Matchers.is(true));
        MatcherAssert.assertThat(it.next(), Matchers.is(8));
        MatcherAssert.assertThat(it.hasNext(), Matchers.is(true));
        MatcherAssert.assertThat(it.next(), Matchers.is(9));
        MatcherAssert.assertThat(it.hasNext(), Matchers.is(false));
    }
}
