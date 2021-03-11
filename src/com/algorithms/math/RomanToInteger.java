package com.algorithms.math;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
	public static void main(String[] args) {
		Map<Character, Integer> values = new HashMap<Character, Integer>();
		values.put('M', 1000);
		values.put('D', 500);
		values.put('C', 100);
		values.put('L', 50);
		values.put('X', 10);
		values.put('V', 5);
		values.put('I', 1);
		String s = "LVIII";
		
		int currentValue =  values.get(s.charAt(s.length()-1));
		int total = currentValue;
		int lastValue = currentValue;
		for(int i = s.length()-2; i>=0; i--) {
			currentValue = values.get(s.charAt(i));
			if(currentValue < lastValue) {
				total = total - currentValue;
			}else {
				total = total + currentValue;
			}
			lastValue = currentValue;
		}
		System.out.println(total);
	}
}
