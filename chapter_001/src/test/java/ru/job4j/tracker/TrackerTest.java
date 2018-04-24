package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Test для класса Tracker.
 */
public class TrackerTest {
    /**
     * Тест метода add.
     */
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        Item result = tracker.add(item);
        assertThat(tracker.findAll()[0], is(result));
    }
    /**
     * Тест метода findAll.
     */
    @Test
    public void whenFindAllThenGetItemsArray() {

    }

    /**
     * Тест метода findById, когда такого id нет в заявках.
     */
    @Test
    public void whenIdIsNotInItemsThenNull() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription1", 123L);
        tracker.add(item1);
        Item result = tracker.findById("");
        Item expected = null;
        assertThat(expected, is(result));
    }

    /**
     * Тест метода findById, когда id = null.
     */
    @Test
    public void whenIdIsNullThenNull() {
        Tracker tracker = new Tracker();
        Item result = tracker.findById(null);
        Item expected = null;
        assertThat(expected, is(result));
    }

    /**
     * Тест метода findById, когда id есть в массиве завок.
     */
    @Test
    public void whenIdIsFoundThenItemFound() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription1", 123L);
        tracker.add(item1);
        Item item2 = new Item("test2", "testDescription2", 123L);
        tracker.add(item2);
        Item item3 = new Item("test3", "testDescription3", 123L);
        Item expected = tracker.add(item3);

        Item result = tracker.findById(expected.getId());
        assertThat(expected, is(result));
    }

    /**
     * Тест метода delete, когда id есть в массиве заявок на 1-м элементе.
     */
    @Test
    public void whenDeletedFirstItem() {
        Tracker tracker = new Tracker();
        Item[] expected = tracker.findAll();
        Item item1 = new Item("test1", "testDescription1", 123L);
        tracker.add(item1);
        tracker.delete(item1.getId());
        Item[] result = tracker.findAll();
        assertThat(expected, is(result));
    }

    /**
     * Тест метода delete, когда id есть в массиве заявок.
     */
    @Test
    public void whenDeletedSecondItem() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription1", 123L);
        Item item2 = new Item("test2", "testDescription2", 124L);
        Item item3 = new Item("test3", "testDescription3", 124L);
        tracker.add(item1);
        tracker.add(item3);
        Item[] expected = tracker.findAll();
        tracker.delete(item3.getId());
        tracker.add(item2);
        tracker.add(item3);
        tracker.delete(item2.getId());
        Item[] result = tracker.findAll();
        assertThat(expected, is(result));
    }

    /**
     * Тест метода replace.
     */
    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1","testDescription",123L);
        tracker.add(previous);
        Item next = new Item("test2","testDescription2",1234L);
        next.setId(previous.getId());
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    /**
     * Тест findByName, когда заявка найдена.
     */
    @Test
    public void whenFoundByName() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription1", 123L);
        tracker.add(item1);
        Item[] expected = tracker.findAll();
        Item item2 = new Item("test2", "testDescription2", 124L);
        tracker.add(item2);
        Item item3 = new Item("test3", "testDescription3", 124L);
        tracker.add(item3);
        Item[] result = tracker.findByName("test1");
        assertThat(expected, is(result));
    }

    /**
     * Тест findByName, когда ничего не найдено.
     */
    @Test
    public void whenNotFoundByName() {
        Item[] expected = null;
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription1", 123L);
        tracker.add(item1);
        Item item2 = new Item("test2", "testDescription2", 124L);
        tracker.add(item2);
        Item item3 = new Item("test3", "testDescription3", 124L);
        tracker.add(item3);
        Item[] result = tracker.findByName("абракадабра");
        assertThat(expected, is(result));
    }

    /**
     * Тест findByName, когда ничего не найдено.
     */
    @Test
    public void whenKeyIsNullThenNotFoundByName() {
        Item[] expected = null;
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription1", 123L);
        tracker.add(item1);
        Item item2 = new Item("test2", "testDescription2", 124L);
        tracker.add(item2);
        Item item3 = new Item("test3", "testDescription3", 124L);
        tracker.add(item3);
        Item[] result = tracker.findByName(null);
        assertThat(expected, is(result));
    }
}
