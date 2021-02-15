package com.algorithm.dynamicprogramming;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LongestIncreasingSubsequence {
	public static void main(String[] args) {
		int[] arr = { 3, 10, 2, 1, 20 };
		int[] lis = new int[arr.length];
		IntStream.range(0, lis.length).forEach(i -> lis[i] = 1);
		for (int i = 1; i < arr.length; i++) {
			for (int j =0; j < i; j++) {
				if (arr[i] > arr[j]) {
					lis[i] = Math.max(lis[i],lis[j] + 1);
				}
			}
		}
		System.out.println(Arrays.stream(lis).max().getAsInt());
	}
}
