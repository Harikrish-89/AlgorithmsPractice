package com.algorithms.string;

public class ValidPalindrome {
	public static void main(String[] args) {
		String s = "ab_a";
		String s1 = s.replaceAll("\\W", "").replaceAll("_", "").toLowerCase();
		System.out.println(s1 + "==>" + s1.length());
		int middle = s1.length() % 2 == 0 ? s1.length() / 2 : s1.length() / 2 + 1;
		int left = 0;
		int right = s1.length() - 1;
		while (left <= middle && right >= middle) {
			if (s1.charAt(left) == s1.charAt(right)) {
				left++;
				right--;
			} else {
				System.out.println(false);
				return;
			}
		}
		
		System.out.println(true);
	}
}
