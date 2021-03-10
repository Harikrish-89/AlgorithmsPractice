package com.algorithm.arrays;

import java.util.Random;

public class ShuffleArray {

	int[] array;

	int[] original;

	Random rand = new Random();

	public ShuffleArray(int[] nums) {
		array = nums;
		original = nums.clone();
	}

	public int[] reset() {
		array = original;
		original = original.clone();
		return array;
	}

	public int[] shuffle() {
		for (int i = 0; i < array.length; i++) {
			swapAt(i, randRange(i, array.length));
		}
		return array;
	}

	private void swapAt(int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	private int randRange(int min, int max) {
		return rand.nextInt(max - min) + min;
	}

}
