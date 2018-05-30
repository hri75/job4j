package ru.job4j.departament;

import java.util.*;

/**
 * Отсортировать департаменты [#34352].
 *
 * @author Rustam Harisov <hri75@mail.ru>
 * @since 30.05.2018
 */
public class Departament {

    /**
     * Метод, создающий полный массив наименований подразделений в требуемом порядке сортировки.
     * @param lines - исходный массив наименований подразделений.
     * @param isAscending - порядок сортировки: Истина - сортировка по возрастанию, Ложь - по убыванию.
     * @return - полный массив наименований в требуемом порядке сортировки.
     */
    public String[] sort(String[] lines, boolean isAscending) {

        /**
         * Подразделение, хранящее в себе имя, разложенное в список.
         */
        class Unit {
            /**
             * Имя подразделения, разложенное в список.
             */
            List<String> names;

            /**
             * Полное имя подразделения строкой.
             */
            String description;

            public Unit(List<String> names, String description) {
                this.names = names;
                this.description = description;
            }
        }

        /**
         * Дерево подразделений с компаратором.
         * В компараторе - вся соль требуемой в задании сортировки.
         */
        TreeSet<Unit> treeUnits = new TreeSet<>(new Comparator<Unit>() {
            @Override
            public int compare(Unit o1, Unit o2) {
                int result = 0;
                int koefficient = isAscending ? 1 : -1;
                int lenght = Math.min(o1.names.size(), o2.names.size());
                for (int i = 0; i < lenght; i++) {
                    result = koefficient * o1.names.get(i).compareTo(o2.names.get(i));
                    if (result != 0) {
                        return result;
                    }
                }
                return (o1.names.size() - o2.names.size());
            }
        });
        String regex = "\\\\";
        String delimiter = "\\";
        for (String line : lines) {
            StringBuilder currentName = new StringBuilder();
            String[] names = line.split(regex);
            for (String name : names) {
                if (!"".equals(currentName.toString())) {
                    currentName.append(delimiter);
                }
                currentName.append(name);
                treeUnits.add(new Unit(Arrays.asList(currentName.toString().split(regex)), currentName.toString()));
            }
        }
        String[] result = new String[treeUnits.size()];
        Iterator<Unit> iterator = treeUnits.iterator();
        int index = 0;
        while (iterator.hasNext()) {
            result[index++] = iterator.next().description;
        }
        return result;
    }
}
