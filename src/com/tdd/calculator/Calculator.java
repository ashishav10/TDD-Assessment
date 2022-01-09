package com.tdd.calculator;

public class Calculator {

	public static int add(String input) {
		
		int sum = 0;
//		Empty String
		if(input.isBlank()) {
			return 0;
		}
		else {
			String[] numbers = input.split(",");
			for(String num: numbers)
				sum += Integer.parseInt(num);
			return sum;
		}
	}
}
