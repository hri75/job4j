package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test
 * - класс для тестирования класса Calculate
 * @auther Rustam Harisov (hri75@mail.ru)
 * @version $Id$
 * @since 0.1
 */

public class CalculateTest {
	
	/**
	 * Test echo
	 */
	
	@Test
	public void whenTakeNameThenThreeEchoPlusName() {
	
		String input = "Rustam";
		String expect = "Echo, echo, echo Rustam";
		
		Calculate calc = new Calculate();
		String result = calc.echo(input);
		
		assertThat(result, is(expect));
	}
}