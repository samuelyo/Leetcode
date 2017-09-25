package com.leetcode.SudokuSolver;

public class SudokuSolver2 {

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
		solveSudokuHelper(board);
		
	}
	
	public static boolean solveSudokuHelper(char[][] board) {
		
		for(int i = 0;i<9;i++) {
			for(int j = 0;j<9;j++) {
				if(board[i][j] == '.') {
					for(int value = 1;value <= 9;value ++) {
						char cur = (char) (value + '0');
						if(isValid(board, i, j, cur)) {
							board[i][j] = cur;
							if(solveSudokuHelper(board)) {
								return true;
							}else{
								board[i][j] = '.';
							}
						}
					}
					return false;
				}
			}
		}
		return true;
		
	}

	public static boolean isValid(char[][] board, int i, int j, char c) {
		
		for(int row = 0;row<9;row++) {
			if (board[row][j] != '.' && board[row][j] == c) {
				return false;
			}
		}
		
		for(int col = 0;col<9;col++) {
			if (board[i][col] != '.' && board[i][col] == c) {
				return false;
			}
		}
		
		for(int row = i / 3 * 3;row < i / 3 * 3 + 3;row ++) {
			for(int col = j / 3 * 3;col < j / 3 * 3 + 3;col ++) {
				if(board[row][col] != '.' && board[row][col] == c){
					return false;
				}
			}
		}
		return true;
		
	}
}
