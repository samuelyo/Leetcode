package com.leetcode.SurroundedRegions;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions2 {

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
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		for(int i = 0;i<m;i++){
			solveBFS(board, i, 0, queue);
			solveBFS(board, i, n-1, queue);
		}
		
		for(int i = 0;i<n;i++){
			solveBFS(board, 0, i, queue);
			solveBFS(board, m-1, i, queue);
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
	
	public static void solveBFS(char[][] board, int i, int j, Queue<Integer> queue) {
		
		if(board[i][j] == 'O'){
			board[i][j] = '*';
			queue.add(i * board[0].length + j);
			while(!queue.isEmpty()){
				Integer cur = queue.poll();
				int row = cur / board[0].length;
				int col = cur % board[0].length;
				if(row + 1 >= 0 && col >= 0 && col < board[0].length && row + 1 < board.length && board[row+1][col] == 'O'){
					queue.add((row + 1) * board[0].length + col);
					board[row + 1][col] = '*';
				}
				if(row -1 < board.length && col >= 0 && col < board[0].length && row - 1 >= 0 && board[row - 1][col] == 'O'){
					queue.add((row - 1) * board[0].length + col);
					board[row - 1][col] = '*';
				}
				if(row >= 0 && row < board.length && col + 1 >= 0 && col + 1 < board[0].length && board[row][col + 1] == 'O'){
					queue.add(row * board[0].length + col + 1);
					board[row][col + 1] = '*';
				}
				if(row >= 0 && row < board.length && col - 1 < board[0].length && col - 1 >= 0 && board[row][col - 1] == 'O'){
					queue.add(row * board[0].length + col - 1);
					board[row][col - 1] = '*';
				}
			}
		}
		
	}

}
