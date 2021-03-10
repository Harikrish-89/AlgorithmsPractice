package com.algorithm.arrays;

import java.util.Arrays;
import java.util.stream.Collectors;

public class EqualSidesArrays {
	public static void main(String[] args) {
		int[] array = {1,2,3,4,3,2,1};
		int[] trackSum = new int[array.length];
		int totalSum =  Arrays.stream(array).sum();
		int index = 0;
		trackSum[0] = array[0];
		for(int i=1; i< array.length; i++) {
			trackSum[i] = trackSum[i-1] + array[i];
			if(trackSum[i] == totalSum - trackSum[i]) {
				i = index;
				break;
			}
		}
		System.out.println(index);
	}
}
