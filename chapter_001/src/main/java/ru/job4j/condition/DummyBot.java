package ru.job4j.condition;

/**
 * Class DummyBot - глупый бот
 */
public class DummyBot {
    /**
     * Ответ глупого бота на заданный вопрос.
     * @param question - вопрос.
     * @return ответ бота на вопрос.
     */
    public String answer(String question) {
        String result = "Это ставит меня в тупик. Спросите другой вопрос.";
        if ("Привет, Бот.".equals(question)) {
            result = "Привет, умник.";
        } else if ("Пока.".equals(question)) {
            result = "До скорой встречи.";
        }

        return result;
    }
}
