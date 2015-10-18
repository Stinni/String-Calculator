package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {
	
	public static void main(String args[]) {
		org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
	}

	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testAddWithOneNumber() {
		assertEquals(5, Calculator.add("5"));
	}

	@Test
	public void testAddWithTwoNumbers() {
		assertEquals(20, Calculator.add("12,8"));
	}
}
