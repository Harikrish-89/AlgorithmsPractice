package com.algorithm.arrays;

import java.util.Arrays;

public class RotateArray {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
		int k = 3;
		int[] rotated = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			System.out.println((i+k) % nums.length + "=>" + i);
            rotated[i] = nums[(i + k) % nums.length];
        }
		for(int i=0; i<nums.length; i++) {
			nums[i] = rotated[i];
		}
		Arrays.stream(rotated).forEach(elm -> System.out.println(elm));
	}
}
