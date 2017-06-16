package com.leetcode.WordSearch;

import java.util.ArrayList;
import java.util.List;

public class WordSearch {

	public static void main(String[] args) {

		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'E', 'S' }, { 'A', 'D', 'E', 'E' } };
		String word = "EEEFS";
		System.out.println(exist(board, word));

	}

	public static boolean exist(char[][] board, String word) {

		char[] w = word.toCharArray();
		for (int y = 0; y < board.length; y++) {
			for (int x = 0; x < board[y].length; x++) {
				if (exist(board, y, x, w, 0))
					return true;
			}
		}
		return false;
	}

	public static boolean exist(char[][] board, int y, int x, char[] word, int i) {
		if (i == word.length)
			return true;
		if (y < 0 || x < 0 || y == board.length || x == board[y].length)
			return false;
		if (board[y][x] != word[i])
			return false;
		//marked the visited char
		board[y][x] ^= 256;
		boolean exist = exist(board, y, x + 1, word, i + 1) || exist(board, y, x - 1, word, i + 1)
				|| exist(board, y + 1, x, word, i + 1) || exist(board, y - 1, x, word, i + 1);
		//marked the visited char become unvisited
		board[y][x] ^= 256;
		return exist;
	}

}
