package ru.job4j.set;

/**
 * Коллекция типа Set на базе хэш-таблицы.
 * @param <T> - тип хранимых в коллекции значений.
 */
public class SimpleHashTableSet<T> {

    private Object[] objects;

    /**
     * Начальный размер массива под хранение элементов.
     * Необходимо, чтобы это было простое число.
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
        }
        return isAdded;
    }

    /**
     * Метод проверяет, содержится ли значение в контейнере.
     * @param value - проверяемое значение.
     * @return - Истина - значение содержится в контейнере.
     */
    public boolean contains(T value) {
        boolean isContained = false;
        for (int i = 0; i < this.objects.length; i++) {
            if (value == null ? this.objects[i] == null : value.equals(this.objects[i])) {
                isContained = true;
                break;
            }
        }
        return isContained;
    }

    /**
     * Метод удаляет из контейнера переданное значение, если оно там есть.
     * @param value - удаляемое значение.
     * @return - Истина - значение удалено, Ложь - значение не содержится в контейнере.
     */
    public boolean remove(T value) {
        boolean isRemoved = false;
        for (int i = 0; i < this.objects.length; i++) {
            if (value == null ? this.objects[i] == null : value.equals(this.objects[i])) {
                this.objects[i] = NOT_FILLED;
                isRemoved = true;
                break;
            }
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
        return value.hashCode() % objects.length;
    }

    /**
     * Метод проверяет, есть ли еще в хранилище незаполненные ячейки.
     * Если незаполненных ячеек нет - увеличиваем массив.
     */
    private void checkSize() {
        boolean increaseArray = true;
        for (int i = 0; i < this.objects.length; i++) {
            if (this.objects[i] == NOT_FILLED) {
                increaseArray = false;
                break;
            }
        }
        if (increaseArray) {
            Object[] temp = this.objects;
            this.objects = new Object[this.getNextPrimeNumber(objects.length * 2)];
            initObjects();
            for (int i = 0; i < temp.length; i++) {
                if (temp[i] != NOT_FILLED) {
                    this.objects[hashFunction((T) temp[i])] = temp[i];
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
