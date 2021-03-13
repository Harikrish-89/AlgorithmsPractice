package com.algorithm.arrays;

import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeros {
	public static void main(String[] args) {
		int[][] matrix = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
		Set<Integer> rows = new HashSet<Integer>();
		Set<Integer> cols = new HashSet<Integer>();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 0) {
					rows.add(i);
					cols.add(j);
				}
			}
		}
		for(int i=0;i< matrix.length; i++) {
			if(rows.contains(i)) {
				matrix[i] = new int[matrix[i].length];
			}
			for(int j=0; j< matrix[i].length; j++) {
				if(cols.contains(j)) {
					matrix[i][j] = 0;
				}
			}
		}
		
		/*
		 * int[][] matrix = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } }; for(int i=0;i<
		 * matrix.length; i++) { int col = 0; if(Arrays.stream(matrix[i]).anyMatch(el ->
		 * el==0)) { matrix[i] = new int[matrix[i].length]; } for(int j=0; j<
		 * matrix[i].length; j++) { if(matrix[i][j] == 0) {
		 * 
		 * } } }
		 */


	}
}
