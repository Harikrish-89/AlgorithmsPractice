package com.algorithm.arrays;

import java.util.Arrays;

public class EqualSidesArrays {
	public static void main(String[] args) {
		int[] array = { 20, 10, -80, 10, 10, 15, 35 };
		for (int i = 0; i < array.length; i++) {
			int[] left = Arrays.copyOfRange(array, 0, i);
			int[] right = Arrays.copyOfRange(array, i + 1, array.length);
			if (getSum(left) == getSum(right)) {
				System.out.println(i);
				return;
			}
		}
	}

	public static int getSum(int[] array) {
		return Arrays.stream(array).sum();
	}
}
