package com.algorithm.greedy;

import java.util.Arrays;

public class MinimumAbsoluteDifferenceArray {

	public static void main(String[] args) {
		int[] arr = { -59, -36, -13, 1, -53, -92, -2, -96, -54, 75 };
		Arrays.sort(arr);
		int minDifference = Math.abs(arr[0] - arr[1]);
		for (int i = 0; i < arr.length; i++) {
			minDifference = Math.min(minDifference, Math.abs(arr[i + 1] - arr[i]));
		}
		System.out.println(minDifference);
	}
}
