package com.tdd.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CalculatorTest {

//	Empty String
	@Test
	public void emptyStringTest() {
		assertEquals(0, Calculator.add(""));
	}
	
}
