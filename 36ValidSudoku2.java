package com.leetcode.ValidSudoku;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku2 {

	public static void main(String[] args) {

		char[][] board = { { '.', '8', '7', '6', '5', '4', '3', '2', '1' },
				{ '2', '.', '.', '.', '.', '.', '.', '.', '.' }, { '3', '.', '.', '.', '.', '.', '.', '.', '.' },
				{ '4', '.', '.', '.', '.', '.', '.', '.', '.' }, { '5', '.', '.', '.', '.', '.', '.', '.', '.' },
				{ '6', '.', '.', '.', '.', '.', '.', '.', '.' }, { '7', '.', '.', '.', '.', '.', '.', '.', '.' },
				{ '8', '.', '.', '.', '.', '.', '.', '.', '.' }, { '9', '.', '.', '.', '.', '.', '.', '.', '.' } };
		System.out.println(isValidSudoku(board));

	}

	public static boolean isValidSudoku(char[][] board) {

		boolean[][] row = new boolean[9][9];
		boolean[][] col = new boolean[9][9];
		boolean[][] box = new boolean[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.') {
					int num = board[i][j] - '0' - 1;
					int k = i / 3 * 3 + j / 3;
					if (row[i][num] || col[j][num] || box[k][num]) {
						return false;
					}
					row[i][num] = col[j][num] = box[k][num] = true;
				}
			}
		}
		return true;
	}
}
