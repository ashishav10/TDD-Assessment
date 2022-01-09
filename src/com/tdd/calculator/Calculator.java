package com.tdd.calculator;

import java.util.ArrayList;

public class Calculator {

	public static int add(String input) {

//		Empty String
		if (input.isBlank()) {
			return 0;
		} else {
			String[] numbers;

//			Custom Delimiter
			if (input.startsWith("//"))
				numbers = splitUtilWithCustomDelim(input);
			else
				numbers = splitUtil(input);
			return sumUtil(numbers);
		}
	}

//	delimiter = , or \n
	private static String[] splitUtil(String input) {
		return input.split(",|\n");
	}

//  custom delimiter
	private static String[] splitUtilWithCustomDelim(String input) {

		//		To build regex
		StringBuilder delimiter = new StringBuilder();
		delimiter.append("[");

//		to check for multiple delimiters of variable length
		if (input.contains("[")) {
			for (int i = 0; i < input.length(); i++) {
				if (input.charAt(i) == '\n') {
					input = input.substring(i + 1);
					break;
				}
				if (input.charAt(i) == '[')
					delimiter.append(input.charAt(i + 1));
			}
		} else {
			delimiter.append(input.charAt(2));
			input = input.substring(4);
		}
		delimiter.append("]+");
		return input.split(delimiter.toString());
	}

//  sum the numbers
	private static int sumUtil(String[] numbers) {
		int result = 0;
		ArrayList<String> negatives = new ArrayList<String>();
		for (String strNum : numbers) {
			int num = Integer.parseInt(strNum);

//			to ignore the numbers > 1000
			if (num > 1000)
				continue;

//			to store the negatives to display while exception
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
