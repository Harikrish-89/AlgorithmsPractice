package com.algorithm.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Triplets {
	public static void main(String[] args) {
		int[] nums = { -1, 0, 1, 2, -1, -4 };
		Set<List<Integer>> result = new HashSet<List<Integer>>();
		Set<Integer> dups = new HashSet<>();
		Map<Integer, Integer> numberIndex = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (dups.add(nums[i])) {
				for (int j = i + 1; j < nums.length; j++) {
					int complement = 0 - nums[i] - nums[j];
					if (numberIndex.containsKey(complement) && numberIndex.get(complement) == i) {
						List<Integer> list = Arrays.asList(nums[i], nums[j], complement);
						Collections.sort(list);
						result.add(list);

					}
					numberIndex.put(nums[j], i);
				}
			}
		}
		System.out.println(new ArrayList(result));
		System.out.println(threeSum(nums));
		
		System.out.println(threeSumTwoPointer(nums));
	}

	public static List<List<Integer>> threeSum(int[] nums) {
		Set<List<Integer>> res = new HashSet<>();
		Set<Integer> dups = new HashSet<>();
		Map<Integer, Integer> seen = new HashMap<>();
		for (int i = 0; i < nums.length; ++i)
			if (dups.add(nums[i])) {
				for (int j = i + 1; j < nums.length; ++j) {
					int complement = -nums[i] - nums[j];
					if (seen.containsKey(complement) && seen.get(complement) == i) {
						List<Integer> triplet = Arrays.asList(nums[i], nums[j], complement);
						Collections.sort(triplet);
						res.add(triplet);
					}
					seen.put(nums[j], i);
				}
			}
		return new ArrayList(res);
	}

	public static List<List<Integer>> threeSumTwoPointer(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for (int i = 0; i < nums.length && nums[i] <=0; i++) {
			if(i == 0 || nums[i - 1] != nums[i]) {
				towSum(i,nums,result);
			}
		}
		return result;
	}

	private static void towSum(int i, int[] nums, List<List<Integer>> result) {
		int low = i+1;
		int high = nums.length-1;
		while(low < high) {
			int sum = nums[i]+ nums[low] + nums[high];
			if(sum < 0) {
				low++;
			}else if(sum > 0) {
				high--;
			}else if(sum ==  0) {
				result.add(Arrays.asList(nums[i], nums[low],  nums[high]));
				low++;
				high--;
			}
			while(low < high && nums[low] == nums[low-1]) {
				low++;
			}
		}
	}
}
