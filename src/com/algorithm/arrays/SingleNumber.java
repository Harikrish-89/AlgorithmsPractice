package com.algorithm.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SingleNumber {
	public static void main(String[] args) {
		int[] nums = {2, 2, 1};
		/*
		 * //System.out.println(Arrays.stream(nums).boxed()
		 * .collect(Collectors.groupingBy(Function.identity(),
		 * Collectors.counting())).entrySet().stream() .filter(entry -> entry.getValue()
		 * == 1).map(entry -> entry.getKey()).findFirst().get()); Arrays.sort(nums);
		 */
		Map<Integer, Integer> count = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (count.containsKey(nums[i])) {
				count.put(nums[i], count.get(nums[i]) + 1);
			} else {
				count.put(nums[i], 1);
			}
		}
		System.out.println(count.entrySet().stream().filter(entry -> entry.getValue() == 1).map(entry -> entry.getKey())
				.findFirst().get());
	}
}
