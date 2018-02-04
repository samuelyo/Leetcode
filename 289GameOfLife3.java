package com.leetcode.GameOfLife;

public class GameOfLife3 {

	public static void main(String[] args) {
		
		int[][] board = {{1,0,0,1},
						 {0,1,1,0},
						 {0,1,0,0}};
		gameOfLife(board);
		for(int i = 0;i<board.length;i++){
			for(int j = 0;j<board[i].length;j++){
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}

	}
	
	public static void gameOfLife(int[][] board) {
		
		int m = board.length;
		int n = board[0].length;
		int[][] copy = new int[m][n];
		for(int i = 0;i<m;i++) {
			for(int j = 0;j<n;j++) {
				copy[i][j] = board[i][j];
			}
		}
		for(int i = 0;i<m;i++) {
			for(int j = 0;j<n;j++) {
				int count = count(copy, i, j);
				if(board[i][j] == 1) {
					if(count < 2 || count > 3) {
						board[i][j] = 0;
					}
				}else {
					if(count == 3) {
						board[i][j] = 1;
					}
				}
			}
		}
		
	}
	
	public static int count(int[][] board, int m, int n) {
		
		int count = 0;
		for(int i = -1;i<=1;i++) {
			for(int j = -1;j<=1;j++) {
				int iNew = m + i;
				int jNew = n + j;
				if(iNew == m && jNew == n) {
					continue;
				}
				if(iNew >= 0 && iNew < board.length && jNew >= 0 && jNew < board[0].length && board[iNew][jNew] == 1) {
					count ++;
				}
			}
		}
		return count;
		
	}

}
