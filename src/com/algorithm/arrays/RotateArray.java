package com.algorithm.arrays;

import java.util.Arrays;

public class RotateArray {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
		int k = 3;
		int temp = 0;
		for (int i = nums.length - 1, j = k-1; i > nums.length-k-1 && j >= 0; i--, j--) {
			temp = nums[j];
			nums[j] = nums[i];
			nums[i] = temp;
		}
		Arrays.stream(nums).forEach(elm -> System.out.println(elm));
	}
}
