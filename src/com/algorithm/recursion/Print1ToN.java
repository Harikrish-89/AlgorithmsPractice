package com.algorithm.recursion;

public class Print1ToN {
	public static void main(String[] args) {
		int n = 5;
		int temp = 1;
		printTailRecursionEffecient(n, temp);
		printAfterRecursion(n);
	}

	private static void printAfterRecursion(int n) {
		if(n == 0) {
			return;
		}
		
		printAfterRecursion(n-1);
		System.out.println(n);
	}

	private static void printTailRecursionEffecient(int n, int temp) {
		if(temp > n) {
			return;
		}
		System.out.println(temp);
		printTailRecursionEffecient(n,temp +1);
	}
}
