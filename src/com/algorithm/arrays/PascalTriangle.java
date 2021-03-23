package com.algorithm.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle {
	public static void main(String[] args) {
		int numRows = 5;
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		result.add(Arrays.asList(1));
		if (numRows > 1) {
			result.add(Arrays.asList(1, 1));
			for (int i = 2; i < numRows; i++) {
				int[] arr = new int[i + 1];
				arr[0] = 1;
				arr[i] = 1;
				for (int j = 1; j <= i - 1; j++) {
					int valueAtj = result.get(i - 1).get(j - 1) + result.get(i - 1).get(j);
					arr[j] = valueAtj;
				}
				List<Integer> list = new ArrayList<Integer>();
				for (int k = 0; k < arr.length; k++) {
					list.add(arr[k]);
				}
				result.add(list);
			}
		}

		System.out.println(result);
	}
}
