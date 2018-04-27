package ru.job4j.tracker;

/**
 * Внешний класс - найти заявку по id.
 */
class ShowItemById implements UserAction {

    @Override
    public int key() {
        return 4;
    }

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

    @Override
    public String info() {
        return String.format("%s. %s", this.key(), "Find item by Id");
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
        this.actions[0] = this.new AddItem();
        this.actions[1] = this.new ShowItems();
        this.actions[2] = this.new EditItem();
        this.actions[3] = this.new DeleteItem();
        this.actions[4] = new ShowItemById();
        this.actions[5] = new MenuTracker.ShowItemByName();
        this.actions[6] = this.new ExitProgram();
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
     * @param key
     */
    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }

    /**
     * Внутренний класс - реализует добавление заявки.
     */
    private class AddItem implements UserAction {

        @Override
        public int key() {
            return 0;
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

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Add new Item");
        }
    }

    /**
     * Внутренний класс - редактирование заявки.
     */
    private class EditItem implements UserAction {

        @Override
        public int key() {
            return 2;
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

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Edit item");
        }

    }

    /**
     * Внутренний класс - удаление заявки.
     */
    private class DeleteItem implements UserAction {

        @Override
        public int key() {
            return 3;
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

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Delete item");
        }
    }

    /**
     * Внутренний класс - показать все заявки.
     */
    private class ShowItems implements UserAction {

        @Override
        public int key() {
            return 1;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            Item[] items = tracker.findAll();
            if (items == null) {
                System.out.println("------------ Нет ни одной заявки: --------------");
            } else {
                System.out.println("------------ Все заявки: --------------");
                for (int i = 0; i < items.length; i++) {
                    StringBuilder temp = new StringBuilder();
                    temp.append(i + 1).append(". ").append(tracker.getItemInfo(items[i]));
                    System.out.println(temp.toString());
                }
            }
            System.out.println();
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Show all items");
        }
    }

    /**
     * Статический внутренний класс - найти заявку по имени. (вложенный).
     */
    private static class ShowItemByName implements UserAction {

        @Override
        public int key() {
            return 5;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Введите имя заявки для поиска:");
            Item[] items = tracker.findByName(name);
            if (items == null) {
                System.out.println("Заявки не найдены.");
            } else {
                System.out.println("------------ Найдены заявки: --------------");
                for (int i = 0; i < items.length; i++) {
                    System.out.println(tracker.getItemInfo(items[i]));
                }
            }
            System.out.println();
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Find items by name");
        }
    }

    /**
     * Внутренний класс - "псевдо" - выход.
     */
    private class ExitProgram implements UserAction {

        @Override
        public int key() {
            return 6;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("Выход из программы.");
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Exit Program");
        }
    }

}
