package com.leetcode.ValidSudoku;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku3 {

	public static void main(String[] args) {
		
		char[][] board = {{'5','3','.','.','7','.','.','.','.'},
						{'6','.','.','1','9','5','.','.','.'},
						{'.','9','8','.','.','.','.','6','.'},
						{'8','.','.','.','6','.','.','.','3'},
						{'4','.','.','8','.','3','.','.','1'},
						{'7','.','.','.','2','.','.','.','6'},
						{'.','6','.','.','.','.','2','8','.'},
						{'.','.','.','4','1','9','.','.','5'},
						{'.','.','.','.','8','.','.','7','9'}};
		System.out.println(isValidSudoku(board));

	}
	
	public static boolean isValidSudoku(char[][] board) {
		
		for(int i = 0;i<board.length;i++) {
			char[] row = board[i];
			if(!isValid(row)) {
				return false;
			}
		}
		for(int i = 0;i<board[0].length;i++) {
			char[] col = new char[board.length];
			for(int j = 0;j<board.length;j++) {
				col[j] = board[j][i];
			}
			if(!isValid(col)) {
				return false;
			}
		}
		for(int i = 0;i<board[0].length;i+=3) {
			char[] square = new char[9];
			for(int j = 0;j<board.length;j+=3) {
				int index = 0;
				for(int m = i;m<i + 3;m++) {
					for(int n = j;n<j + 3;n++) {
						square[index] = board[m][n];
						index ++;
					}
				}
				if(!isValid(square)) {
					return false;
				}
			}
		}
		return true;
		
	}
	
	public static boolean isValid(char[] ch) {
		
		Set<Integer> set = new HashSet<Integer>();
		for(int i = 0;i<ch.length;i++) {
			if(ch[i] == '.') {
				continue;
			}
			int cur = ch[i] - '0';
			if(cur > 9 || cur < 0) {
				return false;
			}
			if(!set.add(cur)) {
				return false;
			}
		}
		return true;
		
	}

}
