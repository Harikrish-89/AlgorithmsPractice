package com.algorithm.greedy;

import java.util.Arrays;

public class SecondSmallestAndSecondLargest {
	
	public static void main(String[] args) {
		int[] array = {12, 13, 1, 10, 34, 1};
		Arrays.sort(array);
		System.out.println(array[1] + "," + array[array.length-2]);
	}

}
