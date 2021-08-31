package com.algorithm.bitwise;

public class FindMissingNumberXor {
	public static void main(String[] args) {
		int [] arr = {1,2,4};
		int xor=0;
		for(int i=0; i < arr.length; i++) {
			xor = xor ^ arr[i];
		}
		for(int i=1; i<=arr.length+1;i++) {
			xor = xor ^ i;
		}
	
		System.out.println(xor);
	}

}
