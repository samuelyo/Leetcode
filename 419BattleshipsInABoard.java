package com.leetcode.BattleshipsInABoard;

public class BattleshipsInABoard {

	public static void main(String[] args) {
		
		char[][] board = {{'X','.','.','X'},{'.','.','.','X'},{'.','.','.','X'}};
		System.out.println(countBattleships(board));
		

	}

	public static int countBattleships(char[][] board) {
		
		if(board == null || board.length == 0 || board[0].length == 0){
			return 0;
		}
		
		int m = board.length;
		int n = board[0].length;
		
		int count = 0;
		
		for(int i = 0;i<m;i++){
			for(int j = 0;j<n;j++){
				if(board[i][j] == 'X'){
					count ++;
					if( j + 1 < n && board[i][j+1] == 'X' ){
						int index = j+1;
						while(index < n){
							if(board[i][index] == 'X'){
								board[i][index] = '.';
							}else{
								break;
							}
							index ++;
						}
					}else if(i + 1 < m && board[i + 1][j] == 'X'){
						int index = i+1;
						while(index < m){
							if(board[index][j] == 'X'){
								board[index][j] = '.';
							}else{
								break;
							}
							index ++;
						}
					}
				}
			}
		}
		return count;
		
	}
}
