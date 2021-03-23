package com.algorithms.string;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class BasicCalculator {
	public static void main(String[] args) {
		String s = "23+2*2";
		if (s == null || s.isEmpty()) {
			System.out.println(0);
			return;
		}
		int currentNumber = 0, lastNumber = 0, result = 0, l = s.length();
		Character o = '+';
		for (int i = 0; i < l; i++) {
			char currentChar = s.charAt(i);
			if (Character.isDigit(currentChar)) {
				currentNumber = (currentNumber * 10) + (currentChar - '0');
			}
			if (!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar) || i == l - 1) {
				if(o == '+' || o == '-') {
					result += lastNumber;
					lastNumber = o == '+' ? currentNumber : -currentNumber;
				}else if(o == '*') {
					lastNumber = lastNumber * currentNumber;
				}else if(o == '/') {
					lastNumber = lastNumber / currentNumber;
				}
				o = currentChar;
				currentNumber = 0;
			}
		}
		result += lastNumber;
		System.out.println(result);
	}
}
