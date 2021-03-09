package com.algorithm.dynamicprogramming;

import java.io.IOException;

public class MaxSubsetSum {

	// Complete the maxSubsetSum function below.
	static int maxSubsetSum(int[] nums) {
		int n = nums.length, maxSum = nums[0];
	    for(int i = 1; i < n; ++i) {
	      if (nums[i - 1] > 0) nums[i] += nums[i - 1];
	      maxSum = Math.max(nums[i], maxSum);
	    }
	    return maxSum;
	};

	public static void main(String[] args) throws IOException {
		System.out.println(maxSubsetSum(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
	}
}
