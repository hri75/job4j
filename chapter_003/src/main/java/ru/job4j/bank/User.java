package ru.job4j.bank;

/**
 * Пользователь.
 */
public class User {
    /**
     * Имя пользователя.
     */
    private String name;

    /**
     * Паспорт пользователя.
     */
    private String passport;

    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }

    public String getName() {
        return name;
    }

    public String getPassport() {
        return passport;
    }

    @Override
    public boolean equals(Object anObject) {
        boolean result = false;
        if (anObject instanceof User) {
            User user = (User) anObject;
            result = this == user || (this.name.equals(user.getName()) && this.passport.equals(user.getPassport()));
        }
        return result;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + this.passport.hashCode();
    }
}
