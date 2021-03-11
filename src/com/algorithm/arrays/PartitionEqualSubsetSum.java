package com.algorithm.arrays;

import java.util.Arrays;

public class PartitionEqualSubsetSum {
	public static void main(String[] args) {
		int[] nums = { 1, 1, 1 };
		int k = 2;
		int count[] = new int[nums.length];
		int sumsSoFar = nums[0];
		count[0] = sumsSoFar == k ? 1 : 0;
		for (int i = 1; i < nums.length; i++) {
			sumsSoFar += nums[i];
			if (sumsSoFar <= k) {
				count[i] = count[i - 1] + (sumsSoFar == k ? 1 : 0);
			} else {
				count[i] = count[i - 1] + (nums[i] == k ? 1 : 0);
			}

		}
		System.out.println(count);
	}

}
