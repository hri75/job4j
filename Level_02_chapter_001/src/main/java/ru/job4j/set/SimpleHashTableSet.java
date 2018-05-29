package ru.job4j.set;

import java.util.HashMap;

/**
 * Коллекция типа Set на базе хэш-таблицы.
 * @param <T> - тип хранимых в коллекции значений.
 */
public class SimpleHashTableSet<T> {

    /**
     * Массив, который хранит значения множества.
     */
    private Object[] objects;

    /**
     * Количество свободных ячеек в массиве.
     */
    private int free;

    /**
     * Начальный размер массива под хранение элементов.
     * Необходимо, чтобы это было простое число, чтобы количество коллизий при вычислении хэш-индекса от значения было минимальным.
     */
    private static final int DEFAULT_CAPACITY = 3;

    /**
     * Объект для заполнения хэш-таблицы, чтобы отличить незаполненную ячейку таблицы от null.
     */
    private static final Object NOT_FILLED = new Object();

    /**
     * Конструктор.
     */
    public SimpleHashTableSet() {
        this.objects = new Object[DEFAULT_CAPACITY];
        free = DEFAULT_CAPACITY;
        initObjects();
    }

    /**
     * Метод добавляет значение в контейнер.
     * @param value - добавляемое значение.
     * @return - Истина - значение было добавлено. Ложь - значение уже было в контейнере.
     */
    public boolean add(T value) {
        boolean isAdded = false;
        if (!contains(value)) {
            checkSize();
            this.objects[hashFunction(value)] = value;
            isAdded = true;
            free--;
        }
        return isAdded;
    }

    /**
     * Метод проверяет, содержится ли значение в контейнере.
     * @param value - проверяемое значение.
     * @return - Истина - значение содержится в контейнере.
     */
    public boolean contains(T value) {
        int index = hashFunction(value);
        return (value == null ? this.objects[index] == null : value.equals(this.objects[index]));
    }

    /**
     * Метод удаляет из контейнера переданное значение, если оно там есть.
     * @param value - удаляемое значение.
     * @return - Истина - значение удалено, Ложь - значение не содержится в контейнере.
     */
    public boolean remove(T value) {
        boolean isRemoved = false;
        int index = hashFunction(value);
        if (value == null ? this.objects[index] == null : value.equals(this.objects[index])) {
            this.objects[index] = NOT_FILLED;
            isRemoved = true;
            free++;
        }
        return isRemoved;
    }

    /**
     * Простейшая хэш-функция. Должна выдавать числа от 0 до objects.length.
     * Длину массива objects надо устанавливать в виде простого числа, тогда
     * количество "коллизий" будет меньше.
     * @param value - значение элемента.
     * @return - хэш-число.
     */
    private int hashFunction(T value) {
        return (value == null ? 0 : value.hashCode() % objects.length);
    }

    /**
     * Метод проверяет, есть ли еще в хранилище незаполненные ячейки.
     * Если незаполненных ячеек нет - увеличиваем массив. Новая длина массива будет простым числом,
     * чтобы количество коллизий было небольшим.
     */
    private void checkSize() {
        if (free <= 0) {
            Object[] temp = this.objects;
            free = this.getNextPrimeNumber(objects.length * 2);
            this.objects = new Object[free];
            initObjects();
            for (int i = 0; i < temp.length; i++) {
                if (temp[i] != NOT_FILLED) {
                    this.objects[hashFunction((T) temp[i])] = temp[i];
                    free--;
                }
            }
        }
    }

    /**
     * Метод возвращает простое число, следующее за числом, переданным в качестве аргумента.
     * @param number - число, за которым надо найти простое число.
     * @return - простое число.
     */
    private int getNextPrimeNumber(int number) {
        int result = 0;
        boolean continueSearch = true;
        for (int i = number + 1; continueSearch && i < number * number; i++) {
            continueSearch = false;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    continueSearch = true;
                    break;
                }
            }
            result = i;
        }
        return result;
    }

    /**
     * Метод заполняет массив значениями специального объекта NOT_FILLED.
     */
    private void initObjects() {
        for (int i = 0; i < this.objects.length; i++) {
            this.objects[i] = NOT_FILLED;
        }
    }
}
