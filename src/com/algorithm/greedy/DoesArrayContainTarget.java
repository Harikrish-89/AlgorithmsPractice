package com.algorithm.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DoesArrayContainTarget {
	public static void main(String[] args) {
		int target = 16;
		int[] array = {1, 4, 45, 6, 10, 8};
		List<Integer> difference = new ArrayList<Integer>();
		Arrays.stream(array).forEach(elem -> {
			if(difference.contains(target -elem)) {
				System.out.println(true);
			}
			difference.add(elem);
		});
	}
}
