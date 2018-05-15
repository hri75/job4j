package ru.job4j.sort;

/**
 * Пользователь.
 */
public class User implements Comparable<User> {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Для сортировки пользователей - сортировка по Возрасту по возрастанию.
     * @param o - другой пользователь для сравнения с текущим.
     * @return - 0 если возрасты пользователей равны,
     *           +1 если возраст текущего пользователя больше,
     *           -1 если возраст текущего пользователя меньше.
     */
    @Override
    public int compareTo(User o) {
        return Integer.compare(this.getAge(), o.getAge());
    }
}
