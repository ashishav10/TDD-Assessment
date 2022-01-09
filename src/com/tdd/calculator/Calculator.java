package com.tdd.calculator;

public class Calculator {

	public static int add(String input) {

		int sum = 0;
//		Empty String
		if (input.isBlank()) {
			return 0;
		} else {
			String[] numbers = splitUtil(input);
			return sumUtil(numbers);
		}
	}

	private static String[] splitUtil(String input) {
		return input.split(",|\n");
	}

	private static int sumUtil(String[] numbers) {
		int result = 0;
		for (String num : numbers)
			result += Integer.parseInt(num);
		return result;
	}
}
