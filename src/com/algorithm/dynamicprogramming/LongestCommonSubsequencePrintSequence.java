package com.algorithm.dynamicprogramming;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestCommonSubsequencePrintSequence {
	public static void main(String[] args) {
		int[] a = {1,2,3,4,1};
		int[] b = {3,4,1,2,1,3};
		int m = a.length;
		int n = b.length;
		int[][] lcs = new int[m + 1][n + 1];
		Set<Integer> lcsSeries =  new HashSet<Integer>();
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0) {
					lcs[i][j] = 0;
				} else if (a[i - 1] == b[j - 1]) {
					lcs[i][j] = 1 + lcs[i - 1][j - 1];
				} else {
					lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
				}
			}
		}
		int i= a.length, i1= b.length;
        String s="";
        while (i>0 && i1>0) {
            if (a[i-1]==b[i1-1]) {
                s+= a[i-1]+ "  ";
                i--;
                i1--;
            }
            else if (lcs[i][i1-1] > lcs[i-1][i1]) i1--;
            else i--;
        }
        String str_11[]= s.split("  ");
        int a1[]= new int[str_11.length], i5=0;
        for (int i11=str_11.length-1;i11>=0;i11--) a1[i5++]= Integer.parseInt(str_11[i11]);
        //return a1;
		System.out.println(Arrays.copyOfRange(a, a.length-lcs[m][n], a.length));
	}
}
