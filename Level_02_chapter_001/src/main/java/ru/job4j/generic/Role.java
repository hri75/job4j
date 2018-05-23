package ru.job4j.generic;

/**
 * Класс Role.
 */
public class Role extends Base {
    /**
     * Конструктор.
     *
     * @param id - строковый идентификатор.
     */
    protected Role(String id) {
        super(id);
    }

    /**
     * Метод equals - нужен для метода indexOf(), который добавлен в SimpleArray.
     * два объекта Role будут равны друг другу, если их id равны друг другу.
     *
     * @param obj - объект для сравнения.
     * @return - Истина  если объекты равнозначны друг другу.
     */
    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (obj != null
                && obj instanceof Role
                && (this == obj || (this.getId() == null && (((Role) obj).getId() == null))
                || (this.getId().equals(((Role) obj).getId())))) {
            result = true;
        }
        return result;
    }

    /**
     * equals и hashCode должны соответствовать друг другу, если o1.equals(o2) == true, то и o1.hashCode() == o2.hashCode.
     *
     * @return - целое число.
     */
    @Override
    public int hashCode() {
        int result = 0;
        if (this.getId() != null) {
            result = this.getId().hashCode();
        }
        return result;
    }
}
