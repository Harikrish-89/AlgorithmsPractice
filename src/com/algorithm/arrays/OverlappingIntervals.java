package com.algorithm.arrays;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class OverlappingIntervals {
	public static void main(String[] args) {
		int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
		Arrays.sort(intervals, (i1,i2) -> Integer.compare(i1[0], i2[0]));
		Deque<int[]> stack = new ArrayDeque<int[]>();
		for(int[] currentInterval : intervals) {
			if(stack.isEmpty()) {
				stack.push(currentInterval);
			}else {
				int[] lastInterval = stack.peek();
				if(lastInterval[1] < currentInterval[0]) {
					stack.push(currentInterval);
				}else {
					lastInterval[1] = Math.max(currentInterval[1], lastInterval[1]);
				}
			}
		}
		System.out.println(stack.toArray(new int[stack.size()][2]));
	}
}
