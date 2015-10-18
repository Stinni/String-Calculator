package is.ru.stringcalculator;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.rules.ExpectedException;

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

	@Test
	public void testAddWithTwoMultipleNumbers() {
		assertEquals(100, Calculator.add("20,10,12,8,6,14,9,11,5,5"));
	}

	@Test
	public void testAddWithNumbersCommaAndNewLine() {
		assertEquals(7, Calculator.add("2\n2,3"));
	}

	@Test
	public void testAddWithNumbersAndNewLine() {
		assertEquals(20, Calculator.add("2\n12\n6"));
	}

	@Test
	public void testAddWithSemiColonAsDelimiter() {
		assertEquals(32, Calculator.add("//;\n22;10"));
	}

	@Test
	public void testAddWithColonAsDelimiter() {
		assertEquals(33, Calculator.add("//:\n22:11"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testIfExceptionIsThrownIfOnlyOneNegativeNumber() throws IllegalArgumentException {
		try {
			Calculator.add("-50");
		} catch (IllegalArgumentException e) {
			String expectedMessage = "Negatives not allowed: -50";
			assertEquals(expectedMessage, e.getMessage());
			throw e;
		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void testIfExceptionIsThrownIfNegativeNumber() throws IllegalArgumentException {
		try {
			Calculator.add("10,-1");
		} catch (IllegalArgumentException e) {
			String expectedMessage = "Negatives not allowed: -1";
			assertEquals(expectedMessage, e.getMessage());
			throw e;
		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void testIfExceptionIsThrownIfNegativeNumbers() throws IllegalArgumentException {
		try {
			Calculator.add("10,-1,-10,-5,50");
		} catch (IllegalArgumentException e) {
			String expectedMessage = "Negatives not allowed: -1,-10,-5";
			assertEquals(expectedMessage, e.getMessage());
			throw e;
		}
	}

	@Test
	public void testOneNumberAbove1000() {
		assertEquals(0, Calculator.add("1001"));
	}

	@Test
	public void testMultipleNumbersAbove1000() {
		assertEquals(120, Calculator.add("20000,1212,30\n4000,90"));
	}

	/*@Test
	public void testAddWithLongerDelimiter1() {
		assertEquals(34, Calculator.add("//[***]\n22***10***2"));
	}*/
}
