package com.algorithm.bitwise;

public class PowerOf2 {
	public static void main(String[] args) {
		int n = 6;
		System.out.println(n != 0 && (n & (n-1)) == 0 );
	}
}
