package ru.job4j.map;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;

/**
 * 9.1. Рассказать и продемонстрировать как переопределяют метод hashCode [#9881].
 * @author Rustam Harisov <hri75@mail.ru>
 * @since 29.05.2018
 *
 * Рассказ:
 * Т.к. по бизнес-логике я переопределил метод equals, то необходимо переопределить метод hashCode,
 * чтобы выполнялось условие: если equals для двух объектов возвращает Истину, то хэш-коды этих объектов
 * должны быть равны друг другу.
 *
 * Я воспользовался сгенерированным IDEA методом hashCode. В-принципе, метод повторяет то, что написано у Блоха:
 * для каждого поля вычисляем хэш-код и объединяем с уже полученным хэш-кодом
 * через result = 31 * result + с;
 *
 * В книге приводится такой алгоритм:
 *
 * 1. Присвойте переменной result (тип int ) некоторое ненулевое число, скажем, 17.
 * 2. Для каждого значимого поля f в вашем объекте (т.е. поля, значение которого
 * принимается в расчёт методом equals ) выполните следующее:
 * a. Вычислите для этого поля хэш-код типа int.
 * i. Если поле имеет тип boolean , вычислите (f ? 1 : 0) .
 * ii. Если поле имеет тип byte , char , short или int , вычислите (int)f .
 * iii. Если поле имеет тип long , вычислите (int) (f ^ (f >>> 32)) .
 * iv. Если поле имеет тип float , вычислите Float.floatToIntBits(f) .
 * v. Если поле имеет тип double , вычислите Double.doubleToLongBits(f) , a
 * затем преобразуйте полученное значение, как указано в 2.a.iii.
 * ----------------------------------------------------------------------------
 * Комментарий. Эти алгоритмы повторяют реализацию методов hashCode
 * в соответствующих типах-обёртках ( Boolean , Byte , Character , Short ,
 * Integer , Long , Float и Double соответственно). В Java 8 у каждого из них
 * также появился статический метод hashCode , возвращающий хэш-код для
 * примитивного значения.
 *--------------------------------------------------------------------------------
 * vi. Если поле является ссылкой на объект, а метод equals данного
 * класса сравнивает это поле, рекурсивно вызывая другие методы
 * equals , так же рекурсивно вызывайте для этого поля метод hashCode .
 * Если требуется более сложное сравнение, вычислите для данного
 * поля каноническое представление (canonical representation), а затем
 * вызовите метод hashCode уже для него. Если значение поля равно
 * null , возвращайте значение 0 (можно любую другую константу, но
 * радиционно используется 0 ).
 *--------------------------------------------------------------------------------
 * Комментарий. Начиная с Java 7, то же самое делает статический метод Objects.hashCode(obj).
 * --------------------------------------------------------------------------------
 * vii. Если полея вляетсям ассивом,обрабатываете его так,как если бы каждый
 * его элемент был отдельным полем. Иными словами, вычислите хэш-код
 * для каждого значимого элемента, рекурсивно применяя данные правила,
 * а затем объединяя полученные значения так, как описано в 2.Ь.
 * ------------------------------------------------------------------------
 * Комментарий. Начиная с Java 5, то же самое делает статический метод Arrays.hashCode(array).
 * ------------------------------------------------------------------------
 * b. Объедините хэш-код с, вычисленный на этапе а, с текущим значением поля
 * result следующим образом:
 * result = 31 * result + с;
 * 3. Верните значение result .
 * 4. Когда вы закончили писать метод hashCode , спросите себя, имеют ли равные
 * экземпляры одинаковый хэш-код. Если нет, выясните, в чем причина, и устраните
 * эту проблему.
 *
 * -----------------------------------------------------------
 * Комментарий. Начиная с Java 7, появился метод Objects.hash(val1, ..., valN)
 * Он вычисляет хэш-код именно по этому алгоритму, с той лишь разницей,
 * что вместо начального значения 17 используется 1.
 */

/**
 * Пример сделан из класса User, просто назвал его ExampleHashCodeOverriding,
 * чтобы User не портить комментариями.
 */
public class ExampleHashCodeOverriding {
    String name;
    int children;
    Calendar birthday;

    public ExampleHashCodeOverriding(String name, int children, Calendar birthday) {
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
            ExampleHashCodeOverriding user = (ExampleHashCodeOverriding) o;
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

    /**
     * Для каждого поля вычисляем хэш-код и объединяем с уже полученным хэш-кодом
     * через result = 31 * result + с;
     * @return - полученный хэш-код.
     */
    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + children;
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        return result;
    }

    public static void main(String[] args) {
        ExampleHashCodeOverriding example = new ExampleHashCodeOverriding("Иванов", 1, new GregorianCalendar(1980, 0, 15));
        int hash1 = example.hashCode();
        int hash2 = Objects.hash(example.name, example.children, example.birthday);
        System.out.println(hash1);
        System.out.println(hash2);
        System.out.println(hash1 - hash2);
    }

}
