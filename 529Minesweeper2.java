package com.leetcode.Minesweeper;

public class Minesweeper2 {

	public static void main(String[] args) {
		
		char[][] board = new char[4][5];
		
		board[0][0] = 'E';
		board[0][1] = 'E';
		board[0][2] = 'E';
		board[0][3] = 'E';
		board[0][4] = 'E';
		
		board[1][0] = 'E';
		board[1][1] = 'E';
		board[1][2] = 'M';
		board[1][3] = 'E';
		board[1][4] = 'E';
		
		board[2][0] = 'E';
		board[2][1] = 'E';
		board[2][2] = 'E';
		board[2][3] = 'E';
		board[2][4] = 'E';
		
		board[3][0] = 'E';
		board[3][1] = 'E';
		board[3][2] = 'E';
		board[3][3] = 'E';
		board[3][4] = 'E';

		int[] click = new int[2];
		
		click[0] = 3;
		click[1] = 0;
		
		char[][] res = updateBoard(board, click);
		char[][] ans = updateBoard(res, new int[]{1,2});
		for(int i = 0;i<ans.length;i++){
			for(int j = 0;j<ans[0].length;j++){
				System.out.print(ans[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static char[][] updateBoard(char[][] board, int[] click) {
		
		int m = click[0];
		int n = click[1];
		
		if(m < 0 || m >= board.length || n < 0 || n >= board[0].length || board[m][n] == 'B'){
			return board;
		}
		
		if(board[m][n] == 'M'){
			board[m][n] = 'X';
			return board;
		}
		int count = 0;
		if(m-1 >= 0 && m-1 < board.length && n-1 >= 0 && n-1 < board[0].length && board[m-1][n-1] == 'M'){
			count ++;
		}
		if(m-1 >= 0 && m-1 < board.length && n >= 0 && n < board[0].length && board[m-1][n] == 'M'){
			count ++;
		}
		if(m-1 >= 0 && m-1 < board.length && n+1 >= 0 && n+1 < board[0].length && board[m-1][n+1] == 'M'){
			count ++;
		}
		if(m >= 0 && m < board.length && n-1 >= 0 && n-1 < board[0].length && board[m][n-1] == 'M'){
			count ++;
		}
		if(m >= 0 && m < board.length && n+1 >= 0 && n+1 < board[0].length && board[m][n+1] == 'M'){
			count ++;
		}
		if(m+1 >= 0 && m+1 < board.length && n-1 >= 0 && n-1 < board[0].length && board[m+1][n-1] == 'M'){
			count ++;
		}
		if(m+1 >= 0 && m+1 < board.length && n >= 0 && n < board[0].length && board[m+1][n] == 'M'){
			count ++;
		}
		if(m+1 >= 0 && m+1 < board.length && n+1 >= 0 && n+1 < board[0].length && board[m+1][n+1] == 'M'){
			count ++;
		}
		
		if(count != 0){
			board[m][n] = (char) ('0' + count);
			return board;
		}else{
			board[m][n] = 'B';
			updateBoard(board, new int[]{m-1,n-1});
			updateBoard(board, new int[]{m-1,n});
			updateBoard(board, new int[]{m-1,n+1});
			updateBoard(board, new int[]{m,n-1});
			updateBoard(board, new int[]{m,n+1});
			updateBoard(board, new int[]{m+1,n-1});
			updateBoard(board, new int[]{m+1,n});
			updateBoard(board, new int[]{m+1,n+1});
			return board;
		}
	}
}
