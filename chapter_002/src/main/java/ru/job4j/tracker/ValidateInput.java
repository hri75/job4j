package ru.job4j.tracker;

/**
 * Класс, обеспечивающий "валидность" (правильность) введенных данных. Он же является декоратором.
 */
public class ValidateInput implements Input {

    private final Input input;

    /**
     * Конструктор.
     * @param input - объект, обеспечивающий базовую функциональность (ConsoleInput или StubInput).
     */
    public ValidateInput(Input input) {
        this.input = input;
    }

    /**
     * Метод для ввода строковых значений.
     * @param question
     * @return
     */
    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }

    /**
     * Метод для ввода пункта меню - в числовом виде.
     * @param question - вопрос для пользователя.
     * @param range - допустимый диапазон пунктов меню.
     * @return - числовое значение, обозначающее пункт меню.
     */
    public int ask(String question, int[] range) {
        boolean invalid = true;
        int key = -1;
        do {
            try {
                key = this.input.ask(question, range);
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
