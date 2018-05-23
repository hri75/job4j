package ru.job4j.generic;

import java.util.Iterator;

/**
 * Абстрактный класс - родитель для UserStore и RoleStore.
 * @param <T>
 */
public abstract class AbstractStore<T extends Base> implements Store<T> {

    /**
     * Внутри для хранения данных использовать SimpleArray.
     */
    private SimpleArray<T> simpleArray;

    /**
     * Конструтор.
     * @param capacity - количество элементов, которое можно хранить в данном контейнере.
     */
    public AbstractStore(int capacity) {
        this.simpleArray = new SimpleArray<>(capacity);
    }

    @Override
    public void add(T model) {
        this.simpleArray.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        boolean result = false;
        Iterator<T> iterator = this.simpleArray.iterator();
        while (iterator.hasNext()) {
            T element = iterator.next();
            String userId = element.getId();
            if ((id == null && userId == null) || (id != null && id.equals(userId))) {
                int index;
                while ((index = this.simpleArray.indexOf(element)) >= 0) {
                    this.simpleArray.set(index, model);
                    result = true;
                }
            }
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        boolean result = false;
        Iterator<T> iterator = this.simpleArray.iterator();
        while (iterator.hasNext()) {
            T element = iterator.next();
            String userId = element.getId();
            if ((id == null && userId == null) || (id != null && id.equals(userId))) {
                int index;
                while ((index = this.simpleArray.indexOf(element)) >= 0) {
                    this.simpleArray.delete(index);
                    result = true;
                }
            }
        }
        return result;
    }

    @Override
    public T findById(String id) {
        T result = null;
        Iterator<T> iterator = this.simpleArray.iterator();
        while (iterator.hasNext()) {
            T element = iterator.next();
            String userId = element.getId();
            if ((id == null && userId == null) || (id != null && id.equals(userId))) {
                result = element;
                break;
            }
        }
        return result;
    }
}
