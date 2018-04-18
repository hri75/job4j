package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test for class DummyBot
 */
public class DummyBotTest {

    /**
     * Test answer - Привет.
     */
    @Test
    public void whenGreetBot() {
        DummyBot dummyBot = new DummyBot();
        assertThat(dummyBot.answer("Привет, Бот."), is("Привет, умник."));
    }

    /**
     * Test answer - Пока.
     */
    @Test
    public void whenByeBot() {
        DummyBot dummyBot = new DummyBot();
        assertThat(dummyBot.answer("Пока."), is("До скорой встречи."));
    }

    /**
     * Test answer - другой вопрос.
     */
    @Test
    public void whenUnknownBot() {
        DummyBot dummyBot = new DummyBot();
        assertThat(dummyBot.answer(null), is("Это ставит меня в тупик. Спросите другой вопрос."));
    }

}
