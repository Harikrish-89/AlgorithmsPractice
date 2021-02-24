package com.algorithm.dynamicprogramming;

import java.util.stream.IntStream;

public class LongestPalindrome {

	public static void main(String[] args) {
		String s = "abb";
		
		System.out.println(IntStream.range(0, s.length()).mapToObj(i -> {
			String s1 = checkAndGetPlaindromeAround(s, i, i);
			String s2 = checkAndGetPlaindromeAround(s, i, i+1);
			return s1.length() > s2.length() ? s1 : s2;
		}).reduce("",(r1,r2) -> r1.length() > r2.length() ? r1 : r2));
	}

	private static String checkAndGetPlaindromeAround(String s, int l, int r) {
		while(l>=0 && r<s.length() && s.charAt(l) == s.charAt(r)) {
			l--;
			r++;
		}
		return s.substring(l+1, r);
	}

}
