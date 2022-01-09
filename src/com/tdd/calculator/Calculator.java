package com.tdd.calculator;

public class Calculator {

	public static int add(String input) {

		int sum = 0;
//		Empty String
		if (input.isBlank()) {
			return 0;
		} else {
			String[] numbers;
//			Changed Delimiter
			if (input.charAt(0) == '/') {
				String delimiter = Character.toString(input.charAt(2));
				numbers = splitUtilWithDelim(input.substring(4), delimiter);
			} else
				numbers = splitUtil(input);
			return sumUtil(numbers);
		}
	}

	private static String[] splitUtil(String input) {
		return input.split(",|\n");
	}

	private static String[] splitUtilWithDelim(String input, String delimiter) {
		return input.split(delimiter);
	}

	private static int sumUtil(String[] numbers) {
		int result = 0;
		for (String num : numbers)
			result += Integer.parseInt(num);
		return result;
	}
}
