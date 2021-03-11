package com.algorithm.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class ValidSudoku {
	public static void main(String[] args) {

		int[][] sudoku = {
                {5, 3, 4, 6, 7, 8, 9, 1, 2},
                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                {3, 4, 5, 2, 8, 6, 1, 7, 9}
        };
		//true
        System.out.println(validateSudoku(sudoku));

        sudoku[0][0]++;
        sudoku[1][1]++;
        sudoku[0][1]--;
        sudoku[1][0]--;
        //false
        System.out.println(validateSudoku(sudoku));   
        
        sudoku[0][0]--;
        sudoku[1][1]--;
        sudoku[0][1]++;
        sudoku[1][0]++;
        
        sudoku[4][4] = 0;
        // false
        System.out.println(validateSudoku(sudoku));
	}

	private static boolean validateSudoku(int[][] sudoku) {
		List<Map<Integer, Integer>> rows = new ArrayList<Map<Integer, Integer>>();
		List<Map<Integer, Integer>> columns = new ArrayList<Map<Integer, Integer>>();
		List<Map<Integer, Integer>> boxes = new ArrayList<Map<Integer, Integer>>();
		IntStream.range(0, 9).forEach(i -> {
			rows.add(new HashMap<Integer,Integer>());
			columns.add(new HashMap<Integer,Integer>());
			boxes.add(new HashMap<Integer,Integer>());
		});
		for(int i = 0 ; i< 9 ; i++) {
			for(int j =0 ; j < 9; j++) {
				int val = sudoku[i][j];
				if(val < 1) {
					return false;
				}
				int boxIndex =  (i/3) * 3 + j/3;
				rows.get(i).put(val, rows.get(i).getOrDefault(val, 0) + 1);
				columns.get(j).put(val, columns.get(j).getOrDefault(val, 0) +1);
				boxes.get(boxIndex).put(val, boxes.get(boxIndex).getOrDefault(val, 0) +1);
			}
		}
		
		boolean isRowsFine = rows.stream().allMatch(map -> map.values().stream().noneMatch(i -> i > 1));
		boolean isColsFine = columns.stream().allMatch(map -> map.values().stream().noneMatch(i -> i > 1));
		boolean isBoxesFine = boxes.stream().allMatch(map -> map.values().stream().noneMatch(i -> i > 1));
		return isRowsFine && isColsFine && isBoxesFine;
	}
}
