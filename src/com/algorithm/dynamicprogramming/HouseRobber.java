package com.algorithm.dynamicprogramming;

import java.util.Arrays;

public class HouseRobber {


	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 1};
		/**
		 * maxMoney(4) = Max( num[4] + maxMoney(2) , num[4] + maxMoney(1)) 
		 * maxMonedy(2) = maxMondey(0)=0 + elem(2)=2
		 * 
		 * maxMoney(3) = maxMoney(1) + elm(3)
		 * 			   = 1+3 = 4
		 * 
		 */
		
		int [] maxMoney = new int[nums.length];
		maxMoney[0] = nums[0];
		maxMoney[1] = nums[1];
		
		for(int i=2; i < nums.length ; i++) {
			maxMoney[i] =  Math.max(nums[i] + maxMoney[i-2] ,  nums[i] + (i > 2 ? maxMoney[i-3] : 0));
		}
		Arrays.sort(maxMoney);
		System.out.println(maxMoney[nums.length-1]);
	}

}
