package ru.job4j.tracker;

import java.util.Scanner;

public class ConsoleInput implements Input {

    private Scanner scanner = new Scanner(System.in);


    /**
     * Возвращает ответ пользователя.
     * @param question - вопрос, отображаемый пользователю.
     * @return - строка - ответ пользователя.
     */
    @Override
    public String ask(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }

    /**
     * Возвращает ответ пользователя.
      * @param question -  вопрос, отображаемый пользователю.
     * @param range - диапазон возможных ответов (числовой массив)
     * @return - число - ответ пользователя.
     */
    @Override
    public int ask(String question, int[] range) {
        int key = Integer.parseInt(this.ask(question));
        boolean exist = false;
        for (int value: range) {
            if (key == value) {
                exist = true;
                break;
            }
        }
        if (exist) {
            return key;
        } else {
            throw new MenuOutException("Неправильный пункт меню.");
        }
    }
}
