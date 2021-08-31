package com.algorithm.recursion;

public class Palindrome {

	public static void main(String[] args) {
		String s = "abbcbba";
		String s1 = "abba";
		String s2 = "geeks";
	//	System.out.println(isPalindrome(s2, s2.length()));
		System.out.println(isPalindromeReadable(s, 0, s.length() - 1));
	}

	private static boolean isPalindromeReadable(String s, int start, int end) {
		if (start >= end) {
			return true;
		}
		return s.charAt(start) == s.charAt(end) 
				&& isPalindromeReadable(s, start + 1, end - 1);
	}

	private static boolean isPalindrome(String s, int len) {
		if (len == 0 || len == 1) {
			return true;
		}
		return s.toCharArray()[s.length() - len] == s.toCharArray()[len - 1] && isPalindrome(
				s.substring((s.length() - len) + 1, len - 1), s.substring((s.length() - len) + 1, len - 1).length());
	}

}
