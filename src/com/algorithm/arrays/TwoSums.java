package com.algorithm.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TwoSums {
	public static void main(String[] args) {
		int[] nums = { 0, 4, 3, 0 };
		int target = 0;
		int[] result = new int[2];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}

		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i]) && map.get(target - nums[i]) != i) {
				result[0] = i;
				result[1] = map.get(target - nums[i]);
			}
		}

		System.out.println(Arrays.stream(result).boxed().collect(Collectors.toList()));
	}
}
