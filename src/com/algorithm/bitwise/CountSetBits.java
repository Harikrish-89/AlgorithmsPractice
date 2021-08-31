package com.algorithm.bitwise;

public class CountSetBits {
	
	public static void main(String[] args) {
		naive();
		brainAndKerniham();
	}

	private static void brainAndKerniham() {
		int n=10;
		int res = 0;
		while(n > 0) {
			n= n & (n-1);
			res++;
		}
		System.out.println(res);
	}

	private static void naive() {
		int n=10;
		int res = 0;
		while(n > 0) {
			res = res + (n&1);
			n = n>>1;
		}
		System.out.println(res);
	}

}
