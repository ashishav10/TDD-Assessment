package com.tdd.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

public class CalculatorTest {

//	Empty String
	@Test
	public void emptyStringTest() {
		assertEquals(0, Calculator.add(""));
	}

//	Only one number
	@Test
	public void singleNumberTest() {
		assertEquals(10, Calculator.add("10"));
	}

//	Numbers delimited by comma
	@Test
	public void delimitedByCommaTest() {
		assertEquals(10, Calculator.add("5,3,2"));
	}

//	Numbers delimited by newline char
	@Test
	public void delimitedByNewLineCharTest() {
		assertEquals(10, Calculator.add("5\n2,3"));
	}

//	Change delimiter
	@Test
	public void delimiterChangeTest() {
		assertEquals(10, Calculator.add("//;\n5;2;3"));
	}

//	Negative numbers
	@Test
	public void negativeNumbersTest() {
		try {
			Calculator.add("-5,2,-3");
			fail("Exception expected.");
		} catch (RuntimeException e) {
			assertEquals("negatives not allowed: -5 -3", e.getMessage());
		}
	}

//	Number > 1000
	@Test
	public void greaterThanThousandTest() {
		assertEquals(10, Calculator.add("//-\n5-2-3-5436"));
	}

//	Multiple delimiters
	@Test
	public void multipleDelimitersTest() {
		assertEquals(10, Calculator.add("//[***][%%%]\n5%%2*****3"));
	}
}
