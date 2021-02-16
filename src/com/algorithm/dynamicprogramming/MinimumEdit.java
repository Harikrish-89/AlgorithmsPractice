package com.algorithm.dynamicprogramming;

public class MinimumEdit {
	public static void main(String[] args) {
		String s1 = "saturday";
		String s2 = "sunday";

		char[] s1Array = s1.toCharArray();
		char[] s2Array = s2.toCharArray();
		int m = s1.length();
		int n = s2.length();
		int[][] editDist = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0) {
					editDist[i][j] = j;
				} else if (j == 0) {
					editDist[i][j] = i;
				} else if (s1Array[i - 1] == s2Array[j - 1]) {
					editDist[i][j] = editDist[i - 1][j - 1];

				} else if (s1Array[i - 1] != s2Array[j - 1]) {
					editDist[i][j] = 1
							+ Math.min(editDist[i - 1][j - 1], Math.min(editDist[i - 1][j], editDist[i][j - 1]));
				}
			}
		}
		System.out.println(editDist[m][n]);

	}

}
