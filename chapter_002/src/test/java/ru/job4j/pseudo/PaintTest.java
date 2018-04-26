package ru.job4j.pseudo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Тест для класса Paint.
 */
public class PaintTest {
    /**
     * stdout содержит дефолтный вывод в консоль.
     */
    private final PrintStream stdout = System.out;

    /**
     * out - буфер для результата.
     */
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    /**
     * операции перед запуском теста.
     */
    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    /**
     * операции после выполнения теста.
     */
    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }

    /**
     * Тест метода draw у квадрата.
     */
    @Test
    public void whenSquareThenSquare() {
        Square square = new Square();
        String result = square.draw();
        String expected = new StringBuilder().append("****\n")
                                             .append("*  *\n")
                                             .append("*  *\n")
                                             .append("****").toString();
        assertThat(expected, is(result));
    }

    /**
     * Тест метода draw у треугольника.
     */
    @Test
    public void whenTriangleThenTriangle() {
        Triangle triangle = new Triangle();
        String result = triangle.draw();
        String expected = new StringBuilder()
                .append("  *\n")
                .append(" * *\n")
                .append("*****").toString();
        assertThat(expected, is(result));
    }

    /**
     * Тест метода draw у класса Paint.
     */
    @Test
    public void whenDrawSquare() {
        new Paint().draw(new Square());
        String result = new String(out.toByteArray());
        String expected = new StringBuilder()
                .append("****\n")
                .append("*  *\n")
                .append("*  *\n")
                .append("****")
                .append(System.lineSeparator())
                .toString();
        assertThat(expected, is(result));
    }
}
