package com.algorithm.recursion;

public class SumOfDigits {
	public static void main(String[] args) {
		int n = 9978;
		System.out.println(sumOfDigits(String.valueOf(n), String.valueOf(n).length() - 1));
	}

	private static int sumOfDigits(String string, int index) {
		if (index == 0) {
			return Integer.valueOf(String.valueOf(string.charAt(index)));
		}
		return Integer.valueOf(String.valueOf(string.charAt(index))) 
				+ sumOfDigits(string.substring(0, index), index - 1);
	}

}