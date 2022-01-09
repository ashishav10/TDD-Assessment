package com.tdd.calculator;

import java.util.ArrayList;

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

//	delimiter = , or \n
	private static String[] splitUtil(String input) {
		return input.split(",|\n");
	}

//  custom delimiter
	private static String[] splitUtilWithDelim(String input, String delimiter) {
		return input.split(delimiter);
	}

//  sum the numbers
	private static int sumUtil(String[] numbers) {
		int result = 0;
		ArrayList<String> negatives = new ArrayList<String>();
		for (String strNum : numbers) {
			int num = Integer.parseInt(strNum);
			if (num < 0)
				negatives.add(String.valueOf(num));
			result += num;
		}

//		exception for negative numbers
		if (negatives.size() > 0) {
			throw new RuntimeException("negatives not allowed: " + String.join(" ", negatives));
		}
		return result;
	}
}
