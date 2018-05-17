//package com;
//
///**
// * Ревью:
// *
// * 1. Пустой конструктор Convert, не делающий ничего - не нужен, компилятор сам вставит конструктор по умолчанию.
// * 2. В методе makeList в цикле for (int j = 0; j < array[i].length; j++)  нет открывающих и закрывающих скобок.
// * 3. В методе makeArray пустые строки, их надо убрать.
// * 4. В методе makeArray if и else без скобок {}.
// * 5. Комментарии к методам и к самому классу надо сделать в стиле JavaDoc.
// */
//
//import java.util.*;
//
//public class Convert {
//
//    public Convert(){
//
//    }
//
//    //Converts array to list
//    List<Integer> makeList(int[][] array) {
//        ArrayList<Integer> list = new ArrayList<>();
//        for (int i = 0; i < array.length; i++) {
//            for (int j = 0; j < array[i].length; j++)
//                list.add(array[i][j]);
//        }
//        return list;
//    }
//
//
//    //Converts list to array
//    public int[][] makeArray(List<Integer> list, int rws) {
//        Iterator<Integer> iterator = list.iterator();
//        int cls = list.size() / rws + (list.size() % rws == 0 ? 0 : 1);
//
//
//        int[][] array = new int[rws][cls];
//        for (int i = 0; i < rws; i++) {
//            for (int j = 0; j < cls; j++) {
//                if (iterator.hasNext())
//                    array[i][j] = iterator.next();
//                else
//                    array[i][j] = 0;
//            }
//        }
//        return array;
//    }
//}