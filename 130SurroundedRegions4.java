package com.leetcode.SurroundedRegions;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions4 {

	public static void main(String[] args) {

		char[][] board = { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' }, { 'X', 'X', 'O', 'X' },
				{ 'X', 'O', 'X', 'X' } };
		solve(board);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static int m;
	public static int n;
	
	public static void solve(char[][] board) {

		m = board.length;
		if (0 == m)
			return;

		n = board[0].length;
		if (0 == n)
			return;

		// top and bottom
		for (int c = 0; c < n; ++c) {
			if (board[0][c] == 'O')
				bfs(0, c, board);
			if (board[m - 1][c] == 'O')
				bfs(m - 1, c, board);
		}

		// left and right
		for (int r = 0; r < m; ++r) {
			if (board[r][0] == 'O')
				bfs(r, 0, board);
			if (board[r][n - 1] == 'O')
				bfs(r, n - 1, board);
		}

		for (int r = 0; r < m; ++r) {
			for (int c = 0; c < n; ++c) {
				if ('#' == board[r][c])
					board[r][c] = 'O';
				else
					board[r][c] = 'X';
			}
		}

	}

	private static void bfs(int r0, int c0, char[][] board) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(r0 * n + c0);

		while (!q.isEmpty()) {
			int node = q.poll();
			int r = node / n, c = node % n;

			if ('O' != board[r][c])
				continue;
			board[r][c] = '#'; // except.add(r * n + c);

			if (r - 1 > 0)
				q.offer((r - 1) * n + c);
			if (r + 1 < m)
				q.offer((r + 1) * n + c);
			if (c - 1 > 0)
				q.offer(r * n + c - 1);
			if (c + 1 < n)
				q.offer(r * n + c + 1);
		}
	}

}
