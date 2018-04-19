package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import java.util.StringJoiner;

/**
 * Test для класса Paint
 */
public class PaintTest {

    /**
     * Test метода pyramid для высоты = 2.
     */
    @Test
    public void whenPyramid2() {
        Paint paint = new Paint();
        String rst = paint.pyramid(2);
        System.out.println(rst);
        assertThat(rst,
                is(
                        new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                                .add(" ^ ")
                                .add("^^^")
                                .toString()
                )
        );
    }

    /**
     * Test метода pyramid для высоты = 3.
     */
    @Test
    public void whenPyramid3() {
        Paint paint = new Paint();
        String rst = paint.pyramid(3);
        System.out.println(rst);
        assertThat(rst,
                is(
                        new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                                .add("  ^  ")
                                .add(" ^^^ ")
                                .add("^^^^^")
                                .toString()
                )
        );
    }
}
