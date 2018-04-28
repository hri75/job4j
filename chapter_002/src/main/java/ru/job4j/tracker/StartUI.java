package ru.job4j.tracker;

/**
 * Интерактивная работа меню.
 */
public class StartUI {

    /**
     * 6. Exit Program - выйти из программы.
     */
    private static final int EXIT = 6;

    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструктор.
     * @param input - ввод данных.
     * @param tracker - хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основной цикл программы.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        int[] range = menu.getRange();
        while (true) {
            menu.show();
            int key = this.input.ask("Введите пункт меню: ", range);
            if (key == EXIT) {
                break;
            }
            menu.select(key);
        }
    }

    /**
     * Запуск программы.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ValidateInput(), new Tracker()).init();
    }
}
