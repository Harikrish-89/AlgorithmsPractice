package com.algorithms.string;

public class ClosestPalindrome {
	public static void main(String[] args) {
		String s = "1213";
		int mid = s.length()/2;
		int l = mid-1;
		int r = s.length()%2 == 0? mid: mid+1;
		char[] ar = s.toCharArray();
		while(l >= 0 && r <= s.length()-1) {
			ar[r] = ar[l];
			l--;
			r++;
		}
		System.out.println(new String(ar));
	}
}
