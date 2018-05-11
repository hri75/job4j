package ru.job4j.bracket;

public enum Bracket {
    SQUARE('[', ']'),
    ROUND('(', ')'),
    CURLY('{', '}');

    private char begin;
    private char end;

    /**
     * Конструктор.
     * @param begin - символ открывающей скобки.
     * @param end - символ закрывающей скобки.
     */
    Bracket(char begin, char end) {
        this.begin = begin;
        this.end = end;
    }

    public char getBeginBracket() {
        return this.begin;
    }

   public char getEndBracket() {
        return this.end;
    }
}
