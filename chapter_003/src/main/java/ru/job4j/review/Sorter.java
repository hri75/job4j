//package com;
//
///**
// * Ревью:
// *
// * 1. Пустой конструктор Sorter, не делающий ничего - не нужен, компилятор сам вставит конструктор по умолчанию.
// * 2. Set<User> sort (List<User> list) {  - в этой строке пробел между sort (  - не нужен.
// * 3. выражение:
// *        TreeSet<User> sortedList = new TreeSet<>();
// *        sortedList.addAll(list);
// *        return sortedList;
// *        можно заменить на return new TreeSet<>(list);   - есть соответствующий конструктор, оказывается!
// * 4. Наименование метода sortnamelength надо сделать sortNameLength. Так называемая "Верблюжья" запись - не сливается, лучше видно.
// * 5. Пробел между наименованием sortnamelength и скобкой ( не надо.
// * 6. В методе sortnamelength класс compar лучше сделать анонимным.
// * 7. метод sortboth - назвать sortBoth.
// * 8. В методе sortboth - вместо двух компараторов можно сделать один. И сделать его сразу анонимным.
// * 9. Комментариев в стиле JavaDoc нет совсем.
// */
//
//import java.util.*;
//
//public class Sorter {
//
//    public Sorter(){
//
//    }
//
//    Set<User> sort (List<User> list) {
//        TreeSet<User> sortedList = new TreeSet<>();
//        sortedList.addAll(list);
//        return sortedList;
//    }
//
//    List<User> sortnamelength (List<User> list) {
//        Comparator<User> compar = new Comparator<User>() {
//            @Override
//            public int compare (User o1, User o2) {
//                return o1.getName().length() - o2.getName().length();
//            }
//        };
//        list.sort(compar);
//        return list;
//    }
//
//    List<User> sortboth (List<User> list) {
//        Comparator<User> compar1 = new Comparator<User>() {
//            @Override
//            public int compare (User o1, User o2) {
//                return o1.getName().compareTo(o2.getName());
//            }
//        };
//        Comparator<User> compar2 = new Comparator<User>() {
//            @Override
//            public int compare (User o1, User o2) {
//                return o1.getAge() - o2.getAge();
//            }
//        };
//        list.sort(compar1.thenComparing(compar2));
//        return list;
//    }
//}