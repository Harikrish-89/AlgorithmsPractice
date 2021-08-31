package com.algorithm.recursion;

public class ReverseN {
	public static void main(String[] args) {
		int n =5;
		reverse(n);
	}

	private static void reverse(int n) {
		if(n == 0) {
			return;
		}
		System.out.println(n);
		reverse(n-1);
	}

}
