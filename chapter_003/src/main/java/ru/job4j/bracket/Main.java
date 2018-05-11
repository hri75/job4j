package ru.job4j.bracket;

public class Main {

    public static void main(String[] args) {
        //String line = "a[b({c}d)e]";
        String line = "a[b({c}d)e](fff)";
        Info result = Expression.parseBracket(line);
        System.out.println(line);
        System.out.println("valid = " + result.isValid());
        if (result.isValid()) {
            for (Item item : result.getItems()) {
                System.out.println("" + item.getBracket() + ", " + item.getBracket().getBeginBracket() + " нач.позиция = " + item.getBeginPos() + ", кон.позиция = " + item.getEndPos());
            }
        }
    }
}
