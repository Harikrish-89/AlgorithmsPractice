package com.algorithm.greedy;

import java.util.Arrays;

public class MarksCakeWalk {
	public static void main(String[] args) {
		int[] arr = { 7, 4, 9, 6 };
		Arrays.sort(arr);
		Double miles = Double.MIN_VALUE;
		for (int i = arr.length - 1; i >= 0; i--) {
			miles = miles + (arr[i] * Math.pow(2, ((arr.length-1) - i)));
		}
		System.out.println(miles.longValue());
	}

}
