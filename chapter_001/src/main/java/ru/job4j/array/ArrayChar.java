package ru.job4j.array;
/**
 * Обертка над строкой.
 */
public class ArrayChar {
    private char[] data;

    public ArrayChar(String line) {
        this.data = line.toCharArray();
    }

    /**
     * Проверяет. что слово начинается с префикса.
     *
     * @param prefix префикс.
     * @return возвращает Истина, если слово начинается с префикса.
     *
     * Комментарий: Если префикс длиннее, чем исходная строка, возвращает Ложь.
     */
    public boolean startWith(String prefix) {
        boolean result = true;
        char[] value = prefix.toCharArray();
        if (value.length > data.length) {
            result = false;
        } else {
            for (int i = 0; i < value.length; i++) {
                if (value[i] != data[i]) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }
}