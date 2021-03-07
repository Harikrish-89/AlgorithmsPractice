package com.algorithm.arrays;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MoveZeros {
	public static void main(String[] args) {
		int[] nums = { 0, 1, 0, 3, 12 };
		 int[] result = Arrays.stream(nums).filter(i -> i > 0).toArray();
			for (int i = 0; i < nums.length; i++) {
				if(i >= result.length){
	                nums[i] =0;
	            }else {
	            	nums[i] = result[i];
	            }
			}
	        System.out.println(Arrays.stream(nums).boxed().collect(Collectors.toList()));
	        moveZeroOptimised();
	        
	}
	
	private static void moveZeroOptimised() {
		int[] nums = { 0, 1, 0, 3, 12 };
		int lastNonZeroFoundAtIndex = 0;
		for(int i =0; i < nums.length; i++) {
			if(nums[i] != 0) {
				nums[lastNonZeroFoundAtIndex++] = nums[i];
			}
		}
		for(int i=lastNonZeroFoundAtIndex; i< nums.length; i++) {
			nums[i] = 0;
		}
		System.out.println(Arrays.stream(nums).boxed().collect(Collectors.toList()));
	}
}
