package ru.job4j.bracket;

public class Item {
    private Bracket bracket;
    private int beginPos;
    private int endPos;

    /**
     * Конструктор.
     * @param bracket - скобка.
     * @param begin - начальная позиция пары скобки в выражении (отсчет ведется с нуля).
     * @param endPos - конечная позиция пары скобки в выражении (отсчет ведется с нуля).
     */
    public Item(Bracket bracket, int begin, int endPos) {
        this.bracket = bracket;
        this.beginPos = begin;
        this.endPos = endPos;
    }

    public void setEndPos(int endPos) {
        this.endPos = endPos;
    }

    public Bracket getBracket() {
        return bracket;
    }

    public int getBeginPos() {
        return beginPos;
    }

    public int getEndPos() {
        return endPos;
    }
}
