package com.algorithm.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MissingRanges {
	public static void main(String[] args) {
		int[] nums = { 0, 1, 3, 50, 75 };
		int lower = 0;
		int upper = 99;
		List<String> result = new ArrayList<String>();
		int prev = lower - 1;
		for (int i = 0; i <= nums.length; i++) {
			int current = i <= nums.length ? nums[i] : upper + 1;
			if (prev - 1 <= current + 1) {
				result.add(formatForOutput(lower, upper));
			}
		}
	}

	private static String formatForOutput(int lower, int upper) {
		if (lower == upper) {
			return String.valueOf(lower);
		}
		return lower + "=>" + upper;
	}
}
