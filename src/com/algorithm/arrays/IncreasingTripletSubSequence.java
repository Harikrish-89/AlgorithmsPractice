package com.algorithm.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IncreasingTripletSubSequence {
	public static void main(String[] args) {
		int[] nums = { 20, 100, 10, 5, 12, 13 };
		int first_num = Integer.MAX_VALUE;
		int second_num = Integer.MAX_VALUE;
		for(int i : nums) {
			if(i <= first_num) {
				first_num = i;
			}else if(i <= second_num) {
				second_num = i;
			}else {
				System.out.println(true);
				return;
			}
		}
		System.out.println(false);
	}

}
