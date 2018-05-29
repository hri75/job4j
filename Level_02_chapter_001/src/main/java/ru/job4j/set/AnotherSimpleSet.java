package ru.job4j.set;

import ru.job4j.list.DynamicLinkedList;

import java.util.Iterator;

/**
 * @author Rustam Harisov <hri75@mail.ru>
 * @since 29.05.2018
 *
 * задача:
 * 2. Set реализованный на связном списке. [#997]
 */

/**
 * Класс, реализующий множество.
 * @param <T> - тип элементов множества.
 */
public class AnotherSimpleSet<T> implements Iterable<T> {
    private DynamicLinkedList<T> container = new DynamicLinkedList<>();

    public void add(T value) {
        boolean isAllowed = true;
        Iterator<T> iterator = this.iterator();
        while (iterator.hasNext()) {
            if (value == null ? iterator.next() == null : value.equals(iterator.next())) {
                isAllowed = false;
                break;
            }
        }
        if (isAllowed) {
            this.container.add(value);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return this.container.iterator();
    }
}
