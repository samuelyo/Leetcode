package com.leetcode.Minesweeper;

public class Minesweeper3 {

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
		char[][] ans = updateBoard(res, new int[] { 1, 2 });
		for (int i = 0; i < ans.length; i++) {
			for (int j = 0; j < ans[0].length; j++) {
				System.out.print(ans[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static char[][] updateBoard(char[][] board, int[] click) {

		int m = board.length, n = board[0].length;
		int row = click[0], col = click[1];

		if (board[row][col] == 'M') { // Mine
			board[row][col] = 'X';
		} else { // Empty
					// Get number of mines first.
			int count = 0;
			for (int i = -1; i < 2; i++) {
				for (int j = -1; j < 2; j++) {
					if (i == 0 && j == 0)
						continue;
					int r = row + i, c = col + j;
					if (r < 0 || r >= m || c < 0 || c < 0 || c >= n)
						continue;
					if (board[r][c] == 'M' || board[r][c] == 'X')
						count++;
				}
			}

			if (count > 0) { // If it is not a 'B', stop further DFS.
				board[row][col] = (char) (count + '0');
			} else { // Continue DFS to adjacent cells.
				board[row][col] = 'B';
				for (int i = -1; i < 2; i++) {
					for (int j = -1; j < 2; j++) {
						if (i == 0 && j == 0)
							continue;
						int r = row + i, c = col + j;
						if (r < 0 || r >= m || c < 0 || c < 0 || c >= n)
							continue;
						if (board[r][c] == 'E')
							updateBoard(board, new int[] { r, c });
					}
				}
			}
		}

		return board;
	}
}
