package ru.job4j.tracker;

/**
 * Заявка.
 */
public class Item {
    private String id;
    private String name;
    private String desc;
    private long created;
    private String[] comments;

    /**
     * Конструктор.
     * @param name - имя задачи.
     * @param desc - описание задачи.
     * @param created - время создания заявки (тип long).
     */
    public Item(String name, String desc, long created) {
        this.name = name;
        this.desc = desc;
        this.created = created;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
