package com.leetcode.SudokuSolver;

public class SudokuSolver {

	public static void main(String[] args) {
		
		char[][] board = {{'.','.','9','7','4','8','.','.','.'},{'7','.','.','.','.','.','.','.','.'},{'.','2','.','1','.','9','.','.','.'},{'.','.','7','.','.','.','2','4','.'},{'.','6','4','.','1','.','5','9',
			'.'},{'.','9','8','.','.','.','3','.','.'},{'.','.','.','8','.','3','.','2','.'},{'.','.','.','.','.','.','.','.','6'},{'.','.','.','2','7','5','9','.','.'}};
		solveSudoku(board);
		for(int i = 0;i<board.length;i++) {
			for(int j = 0;j<board[0].length;j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}

	}
	
	public static void solveSudoku(char[][] board) {
		
		if(board == null || board.length != 9 || board[0].length != 9) {
			return ;
		}
		solveSudokuHelper(board, 0, 0);
		
	}
	
	public static boolean solveSudokuHelper(char[][] board,  int i, int j) {
		
		if(i == 9) {
			return true;
		}
		if(j == 9) {
			return solveSudokuHelper(board, i + 1, 0);
		}
		if(board[i][j] == '.') {
			for(int value = 1;value <= 9;value ++) {
				board[i][j] = (char) (value + '0');
				if(isValid(board, i, j)) {
					if(solveSudokuHelper(board, i,  j + 1)) {
						return true;
					}
				}
				board[i][j] = '.';
			}
		}else{
			return solveSudokuHelper(board, i, j + 1);
		}
		return false;
		
	}

	public static boolean isValid(char[][] board, int i, int j) {
		
		for(int row = 0;row<9;row++) {
			if(row != i) {
				if(board[row][j] == board[i][j]) {
					return false;
				}
			}
		}
		
		for(int col = 0;col<9;col++) {
			if(col != j) {
				if(board[i][col] == board[i][j]) {
					return false;
				}
			}
		}
		
		for(int row = i / 3 * 3;row < i / 3 * 3 + 3;row ++) {
			for(int col = j / 3 * 3;col < j / 3 * 3 + 3;col ++) {
				if((row != i || col != j) && board[row][col] == board[i][j]){
					return false;
				}
			}
		}
		return true;
		
	}
}
