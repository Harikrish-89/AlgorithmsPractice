package com.algorithm.arrays;

import java.util.stream.IntStream;

public class NewYearChaos {

	public static void main(String[] args) {
		int[] q = { 1, 2, 5, 3, 4, 7, 8, 6 };
		//{1,2,3,4,5,6,7,8}

		int bribes = 0;
		for (int i = q.length - 1; i >= 0; i--) {
			if ((q[i] - (i + 1)) > 2) {
				System.out.println("Too chaotic");
				return;
			}
			for (int j = Math.max(0, q[i] - 1 - 1); j < i; j++)
				if (q[j] > q[i])
					bribes++;
		}
		System.out.println(bribes);
	}

}
