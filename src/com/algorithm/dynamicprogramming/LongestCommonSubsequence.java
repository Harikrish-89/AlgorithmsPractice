package com.algorithm.dynamicprogramming;

public class LongestCommonSubsequence {
	public static void main(String[] args) {
		String s1 = "AGGTAB";
		String s2 = "GXTXAYB";

		char[] x = s1.toCharArray();
		char[] y = s2.toCharArray();
		int m = x.length;
		int n = y.length;

		int[][] lcs = new int[m + 1][n + 1];
		for (int i = 0; i <=m; i++) {
			for (int j = 0; j <=n; j++) {
				if (i == 0 || j == 0) {
					lcs[i][j] = 0;
				} else if (x[i - 1] == y[j - 1]) {
					lcs[i][j] = 1 + lcs[i - 1][j - 1];
				} else {
					lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j-1]);
				}
			}
		}
		System.out.println(lcs[m][n]);
	}

}
