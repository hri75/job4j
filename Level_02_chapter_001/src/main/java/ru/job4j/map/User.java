package ru.job4j.map;

import java.util.Calendar;

public class User {
    String name;
    int children;
    Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        boolean isEqual;
        if (this == o) {
            isEqual = true;
        } else if (o == null || this.getClass() != o.getClass()) {
            isEqual = false;
        } else {
            User user = (User) o;
            if (this.children == user.children
                    && (this.name == null ? user.name == null : this.name.equals(user.name))
                    && (this.birthday == null ? user.birthday == null : this.birthday.equals(user.birthday))) {
                isEqual = true;
            } else {
                isEqual = false;
            }
        }
        return isEqual;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + children;
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        return result;
    }
}
