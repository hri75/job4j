package ru.job4j.bracket;

import java.util.ArrayList;
import java.util.Stack;

public class Expression {
    public static Info parseBracket(String line) {

        /**
         * Стек скобок.
         */
        Stack<Item> stack = new Stack<>();

        /**
         * Список пар скобок.
         */
        ArrayList<Item> items = new ArrayList<>();

        /**
         * В качестве результата возвращается объект с полями valid и items
         */
        Info result = new Info(true, items);

        char[] symbols = line.toCharArray();
        for (int i = 0; i < symbols.length && result.isValid(); i++) {
            for (Bracket bracket : Bracket.values()) {
                if (symbols[i] == bracket.getBeginBracket()) {
                    stack.push(new Item(bracket, i, -1));
                    break;
                } else if (symbols[i] == bracket.getEndBracket()) {
                    if (!stack.empty()) {
                        Item item = stack.pop();
                        if (item.getBracket() == bracket) {
                            item.setEndPos(i);
                            items.add(item);
                        } else {
                            result.setValid(false);
                        }
                    } else {
                        result.setValid(false);
                    }
                    break;
                }
            }
        }
        if (result.isValid()) {
            if (!stack.empty()) {
                result.setValid(false);
                result.setItems(null);
            }
        } else {
            result.setItems(null);
        }
        return result;
    }
}
