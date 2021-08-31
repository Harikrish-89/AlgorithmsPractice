package com.algorithm.arrays;

import java.util.Arrays;
import java.util.stream.Collectors;

public class DuplicatesInSortedArray {
	public static void main(String[] args) {
		int[] nums = {0,0,1,1,1,2,2,3,3,4};
		int i=0;
		for(int j=1; j< nums.length; j++) {
			if(nums[j] != nums[i]) {
				i++;
				nums[i] = nums[j];
			}
		}
		Arrays.stream(nums).forEach(elm -> System.out.println(elm));
		Arrays.stream(nums).distinct().forEach(elm -> System.out.println(elm));
	}

}
