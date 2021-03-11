package com.algorithm.arrays;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualsK {
	public static void main(String[] args) {
		int[] array = { 3, 4, 7, 2, -3, 1, 4, 2, 1 };
		int k = 7;
		Map<Integer, Integer> cumulativeSumCount = new HashMap<Integer, Integer>();
		int count = 0;
		int cumSum = 0;
		cumulativeSumCount.put(0, 1);
		for (int i = 0; i < array.length; i++) {
			cumSum += array[i];
			if (cumulativeSumCount.containsKey(cumSum - k)) {
				count = count + cumulativeSumCount.get(cumSum - k);
			}
			cumulativeSumCount.put(cumSum, (cumulativeSumCount.getOrDefault(cumSum, 0) + 1));
		}
		System.out.println(count);
	}
}
