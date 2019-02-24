package com.leetcode.AvailableCapturesForRook;

public class AvailableCapturesForRook2 {
    public static void main(String[] args) {

    }

    public int numRookCaptures(char[][] board) {
        for (int i = 0; i < board.length; ++i)
            for (int j = 0; j < board[i].length; ++j)
                if (board[i][j] == 'R')
                    return cap(board, i, j, 0, 1) + cap(board, i, j, 0, -1) + cap(board, i, j, 1, 0) + cap(board, i, j, -1, 0);
        return 0;
    }

    public static int cap(char[][] b, int x, int y, int dx, int dy) {
        while (x >= 0 && x < b.length && y >= 0 && y < b[x].length && b[x][y] != 'B') {
            if (b[x][y] == 'p') return 1;
            x += dx;
            y += dy;
        }
        return 0;
    }
}
