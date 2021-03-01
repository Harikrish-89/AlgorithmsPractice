package com.algorithm.dynamicprogramming;

import java.util.Arrays;
import java.util.stream.IntStream;

public class SherlockAndCost {
	public static void main(String[] args) {
		int[] B = { 4, 7, 9 };
		int[] A = new int[B.length];
		if (B[0] < B[1]) {
			A[0] = 1;
			A[1] = B[1];
		} else {
			A[0] = B[0];
			A[1] = 1;
		}
		for (int i = 2; i < B.length; i++) {
			if (A[i - 1] > B[i]) {
				A[i] = 1;
			} else {
				A[i] = A[i - 1] == B[i - 1] ? 1 : B[i];
			}

		}
		int sum = 0;
		for (int i = A.length - 1; i > 0; i--) {
			sum = sum + Math.abs(A[i] - A[i - 1]);
		}
		System.out.println(sum);
		System.out.println(maxCost(B));
	}
	
	public static int maxCost(int[] B) {
		int maxVar = Math.abs(B[1] - 1);
        int maxOne = Math.abs(B[0] - 1);

        for (int i =2; i < B.length; i++) {
            int newMaxVar = Math.max(Math.abs(B[i] - 1) + maxOne,  
                Math.abs(B[i] - B[i-1]) + maxVar);
            int newMaxOne = Math.abs(B[i-1] - 1) + maxVar;
            maxVar = newMaxVar;
            maxOne = newMaxOne;
        }

        return Math.max(maxVar, maxOne);
	}

}
