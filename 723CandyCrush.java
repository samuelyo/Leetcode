package com.leetcode.CandyCrush;

import java.util.ArrayList;
import java.util.List;

public class CandyCrush {

	public static void main(String[] args) {
		
		int[][] board = {
						{110,5,112,113,114},
						{210,211,5,213,214},
						{310,311,3,313,314},
						{410,411,412,5,414},
						{5,1,512,3,3},
						{610,4,1,613,614},
						{710,1,2,713,714},
						{810,1,2,1,1},
						{1,1,2,2,2},
						{4,1,4,4,1014}
		};
		
		int[][] res = candyCrush(board);
		for(int i = 0;i<res.length;i++) {
			for(int j = 0;j<res[0].length;j++) {
				System.out.print(res[i][j] + "\t");
			}
			System.out.println();
		}

	}
	
	public static int[][] candyCrush(int[][] board) {
		
		int m = board.length;
		int n = board[0].length;
		
		while(true) {
			List<int[]> list = new ArrayList<int[]>();
			for(int i = 0;i<m;i++) {
				for(int j = 0;j<n;j++) {
					if(board[i][j] != 0) {
						int i0 = i;
						int i1 = i;
						int j0 = j;
						int j1= j;
						while(i1 < m && i1 < i + 3 && board[i1][j] == board[i][j]) {
							i1 ++;
						}
						while(i0 >= 0 && i0 > i - 3 && board[i0][j] == board[i][j]) {
							i0 --;
						}
						while(j1 < n && j1 < j + 3 && board[i][j1] == board[i][j]) {
							j1 ++;
						}
						while(j0 >= 0 && j0 > j - 3 && board[i][j0] == board[i][j]) {
							j0 --;
						}
						if(i1 - i0 > 3 || j1 - j0 > 3) {
							list.add(new int[]{i, j});
						}
					}
				}
			}
			if(list.isEmpty()) {
				break;
			}
			for(int k = 0;k<list.size();k++) {
				int[] cur = list.get(k);
				board[cur[0]][cur[1]] = 0;
			}
			for(int j = 0;j<n;j++) {
				int t = m - 1;
				for(int i = m - 1;i>=0;i--) {
					if(board[i][j] != 0) {
						board[t][j] = board[i][j];
						t --;
					}
				}
				for(int i = t;i>=0;i--) {
					board[i][j] = 0;
				}
			}
		}
		return board;
	}

	public static void swap(int[][] board, int i, int t, int j) {
		
		int temp = board[t][j];
		board[t][j] = board[i][j];
		board[i][j] = temp;
		
	}
	
	
}
