package com.algorithm.arrays;

public class ProductExceptSelf {
	public static void main(String[] args) {

		int[] nums = { -1, 1, 0, -3, 3 };
		//timeLimitExceededSolution(nums);
		
		int[] l = new int[nums.length];
		int[] r = new int[nums.length];
		int[] ans = new int[nums.length];
		l[0] =1;
		r[nums.length -1] = 1;
		for(int i=1; i< nums.length; i++) {
			l[i] = l[i-1] * nums[i-1];
		}
		for(int i=nums.length-2; i >= 0; i--) {
			r[i] = r[i+1] * nums[i+1];
		}
		for(int i=0; i<nums.length; i++) {
			ans[i] = l[i] * r[i];
		}
		for(int i=0; i< nums.length; i++) {
			System.out.println(ans[i]);
		}
	}

	private static void timeLimitExceededSolution(int[] nums) {
		int[] result = new int[nums.length];
		for(int i=0; i< nums.length ; i++) {
			int product =1;
			for(int j =0 ; j< nums.length; j++) {
				if(j != i) {
					product *= nums[j];
				}
			}
			result[i] = product;
		}
		for(int i=0; i< nums.length; i++) {
			System.out.println(result[i]);
		}
	}
}
