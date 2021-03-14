package com.algorithm.arrays;

public class IncreasingTripletSubArray {
	public static void main(String[] args) {
		int[] nums = { 20, 100, 10, 12, 5, 13 };
		int l = 0, r = 2, n = nums.length;
		while (l < n - 3 && r < n) {
			if (nums[l] < nums[r] && nums[l + 1] < nums[r]) {
				System.out.println(true);
				return;
			} else {
				l++;
				r++;
			}
		}
		System.out.println(false);
	}
}
