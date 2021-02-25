package com.algorithm.greedy;

public class CheifHopper {
	public static void main(String[] args) {
		int[] arr = { 3, 4, 3, 2, 4 };
		int energy = 0;
		for (int i = arr.length - 1; i > 0; i--) {
			energy = (energy +arr[i] + 1)/2;
		}
		System.out.println(energy); 
	}

}
