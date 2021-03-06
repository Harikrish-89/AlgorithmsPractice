package com.algorithm.arrays;

public class RotateArray {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
		int k = 3;
		int[] rotated = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
            rotated[(i + k) % nums.length] = nums[i];
        }
		for(int i=0; i<nums.length; i++) {
			nums[i] = rotated[i];
		}
		
	}
}
