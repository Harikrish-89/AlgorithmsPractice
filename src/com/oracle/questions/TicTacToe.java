package com.oracle.questions;

class TicTacToe {

	int[] rows;
	int[] cols;
	int diag;
	int antiDiag;

	int size;

	public TicTacToe(int n) {
		size = n;
		rows = new int[n];
		cols = new int[n];
		diag = 0;
		antiDiag = 0;
	}

	public int move(int row, int col, int player) {
		if(player ==1) {
			int rowCount = ++rows[row] ;
			int colCount = ++cols[col] ;
			if(row==col) {
				diag++;
			}
			if(row + col == size-1) {
				antiDiag ++;
			}
			if(rowCount == size || colCount == size || diag == size || antiDiag == size) {
				return 1;
			}
		}else {
			int rowCount = --rows[row];
			int colCount = --cols[col];
			if(row==col) {
				diag--;
			}
			if(row + col == size-1) {
				antiDiag--;
			}
			if(rowCount == -size || colCount == -size || diag == -size || antiDiag == -size) {
				return 2;
			}
		}
		return 0;
	}

}