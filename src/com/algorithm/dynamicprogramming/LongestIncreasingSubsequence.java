package com.algorithm.dynamicprogramming;

import java.util.Arrays;
import java.util.stream.IntStream;

public class LongestIncreasingSubsequence {
	public static void main(String[] args) {
		int[] arr = { 1,3,6,7,9,4,10,5,6 };

		int[] lis = new int[arr.length];
		IntStream.range(0, lis.length).forEach(i -> lis[i] = 1);
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					lis[i] = Math.max(lis[i], lis[j] + 1);
				}
			}
		}
		System.out.println(Arrays.stream(lis).max().getAsInt());

		//System.out.println(lengthOfLIS(arr));
	}

	public static int lengthOfLIS(int[] nums) {
		return lengthofLIS(nums, Integer.MIN_VALUE, 0);
	}

	public static int lengthofLIS(int[] nums, int prev, int curpos) {
		if (curpos == nums.length) {
			return 0;
		}
		int taken = 0;
		if (nums[curpos] > prev) {
			taken = 1 + lengthofLIS(nums, nums[curpos], curpos + 1);
		}
		int nottaken = lengthofLIS(nums, prev, curpos + 1);
		return Math.max(taken, nottaken);
	}
}
