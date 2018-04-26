package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Тест класса StartUI
 */
public class StartUITest {

    /**
     * Тест добавления заявки.
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }

    /**
     * Тест редактирования заявки.
     */
    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("proba", "desc1", 123L));
        Input input = new StubInput(new String[]{"2", item.getId(), "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test name"));
    }

    /**
     * Тест удаления единственной заявки.
     */
    @Test
    public void whenUserDeletedItemThenTrackerHasNoItems() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("proba", "desc1", 123L));
        Input input = new StubInput(new String[]{"3", item.getId(), "6"});
        new StartUI(input, tracker).init();
        Item[] expected = null;
        Item[] result = tracker.findAll();
        assertThat(expected, is(result));
    }

    /**
     * Тест удаления первой из двух заявок.
     */
    @Test
    public void whenUserAddTwoIemsAndDeletedFirstItemThenTrackerHasOneItem() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("test1", "desc1", 123L));
        Item item2 = tracker.add(new Item("test2", "desc2", 123L));
        Input input = new StubInput(new String[]{"3", item1.getId(), "6"});
        new StartUI(input, tracker).init();
        Item[] result = tracker.findAll();
        assertThat(result[0].getName(), is("test2"));
    }

}
