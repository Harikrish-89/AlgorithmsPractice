package com.algorithm.arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	public static void main(String[] args) {
		int[][] spiral = { { 1, 2, 3, 4 }, 
							{ 5, 6, 7, 8 }, 
							{ 9, 10, 11, 12 } 
							};
		List<Integer> ans = new ArrayList<Integer>();
		int r1 = 0, r2 = spiral.length - 1;
		int c1 = 0, c2 = spiral[0].length - 1;
		while (r1 <= r2 && c1 <= c2) {
			for(int t=c1; t<c2;t++) {
				ans.add (spiral[r1][t]);
			}
			for(int r=r1; r < r2; r++) {
				ans.add(spiral[r][c2]);
			}
			for(int b=c2; b>c1; b--) {
				ans.add(spiral[r2][b]);
			}
			for(int l=r2; l>r1; l--) {
				ans.add(spiral[l][c1]);
			}
			r1++;
			c1++;
			r2--;
			c2--;
		}
	}
}
