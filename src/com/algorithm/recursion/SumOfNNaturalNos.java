package com.algorithm.recursion;

public class SumOfNNaturalNos {
	public static void main(String[] args) {
		int n = 6;
		System.out.println(sum(6));
		System.out.println((n*(n+1))/2);
	}

	private static int sum(int i) {
		if(i==0) {
			return 0;
		}
		return i + sum(i-1);
	}

}
