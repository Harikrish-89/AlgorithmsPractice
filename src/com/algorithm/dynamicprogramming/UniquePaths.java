package com.algorithm.dynamicprogramming;

public class UniquePaths {
	public static void main(String[] args) {
		int m = 3, n = 7;
		int[][] uniquePaths = new int[3][7];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				uniquePaths[i][j] = 1;
			}
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				uniquePaths[i][j] = uniquePaths[i - 1][j] + uniquePaths[i][j - 1];
			}
		}
		System.out.println(uniquePaths[m - 1][n - 1]);
	}
}
