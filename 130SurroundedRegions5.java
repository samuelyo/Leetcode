package com.leetcode.SurroundedRegions;

public class SurroundedRegions5 {

	public static void main(String[] args) {
		
		char[][] board = {{'X','X','X','X'},
						  {'X','O','O','X'},
						  {'X','X','O','X'},
						  {'X','O','X','X'}};
		solve(board);
		for(int i = 0;i<board.length;i++){
			for(int j = 0;j<board[0].length;j++){
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}

	}
	
	public static void solve(char[][] board) {
		
		if(board == null || board.length == 0 || board[0].length == 0) {
			return ;
		}
		int m = board.length;
		int n = board[0].length;
		
		for(int j = 0;j<n;j++) {
			solveHelp(board, 0, j);
			solveHelp(board, m - 1, j);
		}
		for(int i = 0;i<m;i++) {
			solveHelp(board, i, 0);
			solveHelp(board, i, n - 1);
		}
		
		for(int i = 0;i<m;i++) {
			for(int j = 0;j<n;j++) {
				if(board[i][j] == 'O') {
					board[i][j] = 'X';
				}
			}
		}
		
		for(int i = 0;i<m;i++) {
			for(int j = 0;j<n;j++) {
				if(board[i][j] == '1') {
					board[i][j] = 'O';
				}
			}
		}
		
	}
	
	public static void solveHelp(char[][] board, int i, int j) {
		
		if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O') {
			return ;
		}
		board[i][j] = '1';
		solveHelp(board, i + 1, j);
		solveHelp(board, i - 1, j);
		solveHelp(board, i, j + 1);
		solveHelp(board, i, j - 1);
	
	}

}
