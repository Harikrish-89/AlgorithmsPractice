package com.algorithms.string;

public class LongestPalindromeReVisitedWithSlidingWindow {
	public static void main(String[] args) {
		String s = "babad";
		String longPalindrome = "";
		int n = s.length();
		if (s.length() == 1) {
			System.out.println(s);
		}
		for (int i = 0; i < n; i++) {
			String pal1 =  checkPal(s, i, i);
			String pal2 = checkPal(s, i, i+1);
			String curLongPal = pal1.length() > pal2.length() ? pal1 : pal2;
			longPalindrome = longPalindrome.length() > curLongPal.length() ? longPalindrome : curLongPal;
		}
		
		System.out.println(longPalindrome);

	}

	private static String checkPal(String s, int l, int r) {
		while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
			l--;
			r++;
		}
		return s.substring(l+1,r);
	}
}
