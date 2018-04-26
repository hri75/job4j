package ru.job4j.tracker;

/**
 * Интерактивная работа меню.
 */
public class StartUI {

    /**
     * 0. Add new Item - добавление новой заявки.
     */
    private static final String ADD = "0";

    /**
     * 1. Show all items - показать все заявки.
     */
    private static final String SHOW = "1";

    /**
     * 2. Edit item - редактировать заявку.
     */
    private static final String EDIT = "2";

    /**
     * 3. Delete item - удалить заявку.
     */
    private static final String DELETE = "3";

    /**
     * 4. Find item by Id - найти заявку по id.
     */
    private static final String ID = "4";

    /**
     * 4. Find item by name - найти заявку по имени.
     */
    private static final String NAME = "5";

    /**
     * 6. Exit Program - выйти из программы.
     */
    private static final String EXIT = "6";

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
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню: ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (SHOW.equals(answer)) {
                this.showItems();
            } else if (EDIT.equals(answer)) {
                this.editItem();
            } else if (DELETE.equals(answer)) {
                this.deleteItem();
            } else if (ID.equals(answer)) {
                this.showItemById();
            } else if (NAME.equals(answer)) {
                this.showItemsByName();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

    /**
     * Показывает пункты меню на экране.
     */
    private void showMenu() {
        System.out.println("Меню:");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }

    /**
     * Метод реализует добавление новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc, System.currentTimeMillis());
        this.tracker.add(item);
        System.out.println("------------ Создана новая заявка с getId : " + item.getId() + "-----------");
    }

    /**
     * Показать все заявки.
     */
    private void showItems() {
        Item[] items = this.tracker.findAll();
        if (items == null) {
            System.out.println("------------ Нет ни одной заявки: --------------");
        } else {
            System.out.println("------------ Все заявки: --------------");
            for (int i = 0; i < items.length; i++) {
                StringBuilder temp = new StringBuilder();
                temp.append(i + 1).append(". ").append(this.getItemInfo(items[i]));
                System.out.println(temp.toString());
            }
        }
        System.out.println();
    }

    /**
     * Показать заявку по id.
     */
    private void showItemById() {
        String id = this.input.ask("Введите id заявки для поиска:");
        Item item = this.tracker.findById(id);
        if (item == null) {
            System.out.println("Заявка не найдена.");
        } else {
            System.out.println("------------ Найдена заявка: --------------");
            System.out.println(this.getItemInfo(item));
        }
        System.out.println();
    }

    /**
     * Найти заявки по id.
     */
    private void showItemsByName() {
        String name = this.input.ask("Введите имя заявки для поиска:");
        Item[] items = this.tracker.findByName(name);
        if (items == null) {
            System.out.println("Заявки не найдены.");
        } else {
            System.out.println("------------ Найдены заявки: --------------");
            for (int i = 0; i < items.length; i++) {
                System.out.println(this.getItemInfo(items[i]));
            }
        }
        System.out.println();
    }

    /**
     * Удалить заявку.
     */
    private void deleteItem() {
        String id = this.input.ask("Введите id заявки для удаления:");
        Item item = this.tracker.findById(id);
        if (item == null) {
            System.out.println("Заявка не найдена, удаление невозможно.");
        } else {
            System.out.println("------------ Удалена заявка: --------------");
            System.out.println(this.getItemInfo(item));
            this.tracker.delete(id);
        }
        System.out.println();
    }

    /**
     * Редактировать заявку.
     */
    private void editItem() {
        String id = this.input.ask("Введите id заявки для редактирования:");
        Item old = this.tracker.findById(id);
        if (old == null) {
            System.out.println("Заявка не найдена, редактирование невозможно.");
        } else {
            System.out.println("------------ Вы редактируете заявку: --------------");
            System.out.println(this.getItemInfo(old));
            String name = this.input.ask("Введите новое имя заявки :");
            String desc = this.input.ask("Введите новое описание заявки :");
            Item replacement = new Item(name, desc, System.currentTimeMillis());
            this.tracker.replace(id, replacement);
            System.out.println("------------ Отредактированная заявка стала такой: --------------");
            System.out.println(this.getItemInfo(replacement));
        }
        System.out.println();
    }

    /**
     * Получает информацию по заявке:  ИмяЗаявки, ОписаниеЗаявки, id = ИдентификаторЗаявки.
     * @param item - заявка.
     * @return - строка с ирнформацией по заявке.
     */
    private String getItemInfo(Item item) {
        return new StringBuilder().append(item.getName()).append(", ").append(item.getDesc()).append(", id = ").append(item.getId()).toString();
    }

    /**
     * Запуск программы.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
