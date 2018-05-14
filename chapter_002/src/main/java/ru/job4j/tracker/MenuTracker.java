package ru.job4j.tracker;

import java.util.ArrayList;

/**
 * Внешний класс - найти заявку по id.
 */
class ShowItemById extends BaseAction {

    /**
     * Конструктор вспомогательного класса ShowItemById.
     * @param key - номер пункта меню.
     * @param name - наименование пункта меню.
     */
    public ShowItemById(int key, String name) {
        super(key, name);
    }

    /**
     * Показать заявку, найденную по id.
     * @param input - входная информация.
     * @param tracker - хранилище заявок.
     */
    @Override
    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Введите id заявки для поиска:");
        Item item = tracker.findById(id);
        if (item == null) {
            System.out.println("Заявка не найдена.");
        } else {
            System.out.println("------------ Найдена заявка: --------------");
            System.out.println(tracker.getItemInfo(item));
        }
        System.out.println();
    }
}


/**
 * Меню.
 */
public class MenuTracker {

    private Input input;
    private Tracker tracker;

    /**
     * Конструктор.
     * @param input - пользовательский ввод.
     * @param tracker - хранилище заявок.
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
        this.fillActions();
    }

    private UserAction[] actions = new UserAction[7];

    /**
     * Заполнить массив действий. Статический внутренний класс. для пункта 5.
     */
    public void fillActions() {
        this.actions[0] = this.new AddItem(0, "Add new Item");
        this.actions[1] = this.new ShowItems(1, "Show all items");
        this.actions[2] = this.new EditItem(2, "Edit item");
        this.actions[3] = this.new DeleteItem(3, "Delete item");
        this.actions[4] = new ShowItemById(4, "Find item by Id");
        this.actions[5] = new MenuTracker.ShowItemByName(5, "Find items by name");
        this.actions[6] = this.new ExitProgram(6, "Exit Program");
    }

    /**
     * Показ пунктов меню на экране.
     */
    public void show() {
        System.out.println("Меню:");
        for (UserAction action: actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    /**
     * Выбор действия.
     * @param key - номер пункта меню.
     */
    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }

    /**
     * Внутренний класс - реализует добавление заявки.
     */
    private class AddItem extends BaseAction {

        public AddItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Добавление новой заявки --------------");
            String name = input.ask("Введите имя заявки :");
            String desc = input.ask("Введите описание заявки :");
            Item item = new Item(name, desc, System.currentTimeMillis());
            tracker.add(item);
            System.out.println("------------ Создана новая заявка с getId : " + item.getId() + "-----------");
        }
    }

    /**
     * Внутренний класс - редактирование заявки.
     */
    private class EditItem extends BaseAction {
        public EditItem(int key, String name) {
            super(key, name);
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Введите id заявки для редактирования:");
            Item old = tracker.findById(id);
            if (old == null) {
                System.out.println("Заявка не найдена, редактирование невозможно.");
            } else {
                System.out.println("------------ Вы редактируете заявку: --------------");
                System.out.println(tracker.getItemInfo(old));
                String name = input.ask("Введите новое имя заявки :");
                String desc = input.ask("Введите новое описание заявки :");
                Item replacement = new Item(name, desc, System.currentTimeMillis());
                tracker.replace(id, replacement);
                System.out.println("------------ Отредактированная заявка стала такой: --------------");
                System.out.println(tracker.getItemInfo(replacement));
            }
            System.out.println();
        }
    }

    /**
     * Внутренний класс - удаление заявки.
     */
    private class DeleteItem extends BaseAction {

        public DeleteItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Введите id заявки для удаления:");
            Item item = tracker.findById(id);
            if (item == null) {
                System.out.println("Заявка не найдена, удаление невозможно.");
            } else {
                System.out.println("------------ Удалена заявка: --------------");
                System.out.println(tracker.getItemInfo(item));
                tracker.delete(id);
            }
            System.out.println();
        }
    }

    /**
     * Внутренний класс - показать все заявки.
     */
    private class ShowItems extends BaseAction {

        public ShowItems(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            ArrayList<Item> items = tracker.findAll();
            if (items == null) {
                System.out.println("------------ Нет ни одной заявки: --------------");
            } else {
                System.out.println("------------ Все заявки: --------------");
                for (int i = 0; i < items.size(); i++) {
                    StringBuilder temp = new StringBuilder();
                    temp.append(i + 1).append(". ").append(tracker.getItemInfo(items.get(i)));
                    System.out.println(temp.toString());
                }
            }
            System.out.println();
        }
    }

    /**
     * Статический внутренний класс - найти заявку по имени. (вложенный).
     */
    private static class ShowItemByName extends BaseAction {

        public ShowItemByName(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Введите имя заявки для поиска:");
            //Item[] items = tracker.findByName(name);
            ArrayList<Item> items = tracker.findByName(name);
            if (items == null) {
                System.out.println("Заявки не найдены.");
            } else {
                System.out.println("------------ Найдены заявки: --------------");
                for (int i = 0; i < items.size(); i++) {
                    System.out.println(tracker.getItemInfo(items.get(i)));
                }
            }
            System.out.println();
        }
    }

    /**
     * Внутренний класс - "псевдо" - выход.
     */
    private class ExitProgram extends BaseAction {

        public ExitProgram(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("Выход из программы.");
        }
    }

    public int[] getRange() {
        int[] range = new int[actions.length];
        for (int i = 0; i < actions.length; i++) {
            range[i] = i;
        }
        return range;
    }
}
