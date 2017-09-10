package com.leetcode.SurroundedRegions;

public class SurroundedRegions {

	public static void main(String[] args) {
		
		char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
		solve(board);
		for(int i = 0;i<board.length;i++){
			for(int j = 0;j<board[0].length;j++){
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void solve(char[][] board) {
		
		if(board == null || board.length == 0 || board[0].length == 0){
			return ;
		}
		int m = board.length;
		int n = board[0].length;
		
		for(int i = 0;i<m;i++){
			solveDFS(board, i, 0);
			solveDFS(board, i, n-1);
		}
		
		for(int i = 0;i<n;i++){
			solveDFS(board, 0, i);
			solveDFS(board, m-1, i);
		}
		
		for(int i = 0;i<m;i++){
			for(int j = 0;j<n;j++){
				if(board[i][j] != '*'){
					board[i][j] = 'X';
				}
			}
		}
		
		for(int i = 0;i<m;i++){
			for(int j = 0;j<n;j++){
				if(board[i][j] == '*'){
					board[i][j] = 'O';
				}
			}
		}
		
	}
	
	public static void solveDFS(char[][] board, int i, int j) {
		
		if(board[i][j] == 'O'){
			board[i][j] = '*';
			if(i + 1 < board.length){
				solveDFS(board, i+1, j);
			}
			if(i - 1 >= 0){
				solveDFS(board, i-1, j);
			}
			if(j + 1 < board[0].length){
				solveDFS(board, i, j+1);
			}
			if(j - 1 >= 0){
				solveDFS(board, i, j-1);
			}
		}
		
	}

}
