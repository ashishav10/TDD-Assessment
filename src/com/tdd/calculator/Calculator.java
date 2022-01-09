package com.tdd.calculator;

public class Calculator {

	public static int add(String input) {
		
//		Empty String
		if(input.isBlank()) {
			return 0;
		}
		else {
			return Integer.parseInt(input);
		}
	}
}
