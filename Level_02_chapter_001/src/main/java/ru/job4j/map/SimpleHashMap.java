package ru.job4j.map;

import java.util.Iterator;

/**
 * 8. Реализовать собственную структуру данных - HashMap [#1008]
 */
public class SimpleHashMap<K, V> implements Iterable<SimpleHashMap.Node<K, V>> {

    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private int free;

    /**
     * Внутреннее хранилище в виде массива.
     */
    private Node<K, V>[] table;

    /**
     * Конструктор по-умолчанию.
     */
    public SimpleHashMap() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    /**
     * Конструктор с заданным размером массива table.
     * @param initialCapacity - заданный размер массива table.
     */
    public SimpleHashMap(int initialCapacity) {
        table = new Node[initialCapacity];
        free = initialCapacity;
    }

    /**
     * Метод, вставляющий в Map значение по ключу.
     * @param key - ключ.
     * @param value - значение.
     * @return - Истина если удалось вставить значение (т.е. не было коллизии).
     *
     * Примечание: key.hashCode() & (table.length - 1) даст число в диапазоне от 0 до table.length - 1
     */
    public boolean insert(K key, V value) {
        resize();
        boolean isInserted = false;
        int index = 0;
        if (key != null) {
            index = key.hashCode() & (table.length - 1);
        }
        if (table[index] == null) {
            table[index] = new Node<>(key, value);
            isInserted = true;
            free--;
        } else {
            if (key == null ? table[index].key == null
                    : key.hashCode() == table[index].hashCode() && key.equals(table[index].key)) {
                table[index].value = value;
            }
        }
        return isInserted;
    }

    /**
     * Метод, получающий из Map значение по ключу.
     * @param key - ключ.
     * @return - значение.
     */
    public V get(K key) {
        V result = null;
        int index = getIndex(key);
        if (index >= 0) {
            result = table[index].value;
        }
        return result;
    }

    /**
     * Метод, удаляющий из Map значение по ключу.
     * @param key - ключ.
     * @return - Истина, если в Map был переданный ключ.
     */
    public boolean delete(K key) {
        int index = getIndex(key);
        if (index >= 0) {
            table[index] = null;
        }
        return index >= 0;
    }

    /**
     * Метод ищет индекс ячейки массива с заданным ключом.
     * @param key - ключ.
     * @return - индекс ячейку массива, в которой содержится узел с заданным ключом.
     *          если такой ячейки нет, то возвращается -1.
     */
    private int getIndex(K key) {
        int index = 0;
        if (key != null) {
            index = key.hashCode() & (table.length - 1);
        }
        if (table[index] == null
                || (key == null ? table[index].key != null
                : key.hashCode() != table[index].key.hashCode() || !key.equals(table[index].key))) {
            index = -1;
        }
        return index;
    }

    /**
     * Метод проверяет размер массива, и если размер недостаточен, увеличивает размер массива в 2 раза.
     *
     * Примечание: на коллизии не обращаю внимания, только если в массиве не осталось места - увеличиваю размер массива.
     * (Предусмотрите возможность роста хэш-таблицы при нехватке места для нового элемента).
     */
    private void resize() {
        if (free <= 0) {
            Node<K, V>[] temp = table;
            free = table.length * 2;
            table = new Node[free];
            for (Node<K, V> node : temp) {
                if (node != null) {
                    this.insert(node.key, node.value);
                }
            }
        }
    }

    @Override
    public Iterator<Node<K, V>> iterator() {
        return new Iterator<Node<K, V>>() {
            int position = getStartPosition();
            @Override
            public boolean hasNext() {
                return position < table.length;
            }

            @Override
            public Node<K, V> next() {
                Node<K, V> result = table[position];
                moveCarriage();
                return result;
            }

            private void moveCarriage() {
                for (++position; position < table.length; position++) {
                    if (table[position] != null) {
                        break;
                    }
                }
            }

            private int getStartPosition() {
                int i = 0;
                while (i < table.length) {
                    if (table[i] != null) {
                        break;
                    }
                    i++;
                }
                return i;
            }
        };
    }

    /**
     * Узел для хранения пар значений Ключ - Значение.
     */
    public static class Node<K, V> {
        /**
         * Ключ.
         */
        private K key;
        /**
         * Данные, хранимые в узле.
         */
        private V value;

        /**
         * Конструктор Node.
         */
        private Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

}
