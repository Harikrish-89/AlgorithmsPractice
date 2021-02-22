package com.algorithm.dynamicprogramming;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LongestPalindrome {

	public static void main(String[] args) {
		String s = "abb";
		List<String> lp = new ArrayList<String>();
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == s.charAt(s.length() - 1 - i)) {
				builder.append(s.charAt(i));
			} else {
				lp.add(builder.toString());
				lp.add(String.valueOf(s.charAt(i)));
				builder = new StringBuilder();
			}
		}
		lp.add(builder.toString());
		System.out.println(lp.stream().max(Comparator.comparingInt(String::length)).get());
	}

}
