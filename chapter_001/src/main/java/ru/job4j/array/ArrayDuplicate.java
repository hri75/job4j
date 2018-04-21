package ru.job4j.array;

import java.util.Arrays;

/**
 * Класс ArrayDuplicate - убирает из массива слов дублирующиеся слова.
 */
public class ArrayDuplicate {
    /**
     * Метод remove - убирает из переданного массива слов дублирующиеся слова.
     *
     * @param array - переданный массив слов.
     * @return - массив без дублирующихся слов.
     */
    public String[] remove(String[] array) {
        int duplic = 0; //количество повторяющихся слов.
        String temp; //временная переменная, пригодится для "сдвига".

        // во внешнем цикле нет смысла идти до самого последнего уникального элемента, т.к. надо будет сравнивать его с n+1 элементом, поэтому -1:
        for (int i = 0; i < array.length - duplic - 1; i++) {
            //во внутреннем цикле идем от n+1 до последнего уникального элемента:
            for (int j = i + 1; j < array.length - duplic; j++) {
                if (array[i].equals(array[j])) {
                    duplic++;
                    //сделать сдвиг: кинуть повторяющееся слово в конец, а все остальные сдвинуть влево на место "кинутого" слова.
                    temp = array[j];
                    for (int k = j; k < array.length - 1; k++) {
                        array[k] = array[k + 1];
                    }
                    array[array.length - 1] = temp;
                    j--; //надо снова проверить элемент с j-м индексом, вдруг там опять повторяющееся слово.
                }
            }
        }
        return Arrays.copyOf(array, array.length - duplic);
    }
}




