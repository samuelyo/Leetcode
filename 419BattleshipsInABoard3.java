package com.leetcode.BattleshipsInABoard;

public class BattleshipsInABoard3 {

	public static void main(String[] args) {
		
		char[][] board = {{'X','.','.','X'},
				          {'.','.','.','X'},
				          {'.','.','.','X'}};
		System.out.println(countBattleships(board));

	}
	
	public static int countBattleships(char[][] board) {
		
		if(board == null || board.length == 0 || board[0].length == 0) {
			return 0;
		}
		int m = board.length;
		int n = board[0].length;
		int res = 0;
		for(int i = 0;i<m;i++) {
			for(int j = 0;j<n;j++) {
				if(board[i][j] == 'X') {
					res ++;
					int temp = j;
					while(temp < n && board[i][temp] == 'X') {
						board[i][temp] = '.';
						temp ++;
					}
					temp = i + 1;
					while(temp < m && board[temp][j] == 'X') {
						board[temp][j] = '.';
						temp ++;
					}
				}
			}
		}
		return res;
		
	}

}
