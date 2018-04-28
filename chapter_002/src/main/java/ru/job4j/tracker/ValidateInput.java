package ru.job4j.tracker;

public class ValidateInput extends ConsoleInput {
    public int ask(String question, int[] range) {
        boolean invalid = true;
        int key = -1;
        do {
            try {
                key = super.ask(question, range);
                invalid = false;
            } catch (MenuOutException ex) {
                System.out.println("Введите пункт меню из диапазона!");
            } catch (NumberFormatException ex) {
                System.out.println("Введите правильный пункт меню!");
            }
        } while (invalid);
        return key;
    }
}
