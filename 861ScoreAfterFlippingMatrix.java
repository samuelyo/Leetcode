package com.leetcode.ScoreAfterFlippingMatrix;

public class ScoreAfterFlippingMatrix {
    public static void main(String[] args) {
        int[][] A = {{0, 0, 1, 1}, {1, 0, 1, 0}, {1, 1, 0, 0}};
        int res = matrixScore(A);
        System.out.println(res);
    }

    public static int matrixScore(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        for (int i = 0; i < m; i++) {
            if (A[i][0] == 0) {
                flipRow(A, i);
            }
        }
        for (int j = 1; j < n; j++) {
            int count_0 = 0;
            int count_1 = 0;
            for (int i = 0; i < m; i++) {
                if (A[i][j] == 0) {
                    count_0++;
                } else {
                    count_1++;
                }
            }
            if (count_0 >= count_1) {
                flipCol(A, j);
            }
        }
        int sum = 0;
        for (int i = 0; i < m; i++) {
            String row = "";
            for (int j = 0; j < n; j++) {
                row += A[i][j];
            }
            sum += Integer.valueOf(row, 2);
        }
        return sum;
    }

    public static void flipRow(int[][] A, int row) {
        int n = A[0].length;
        for (int j = 0; j < n; j++) {
            if (A[row][j] == 0) {
                A[row][j] = 1;
            } else {
                A[row][j] = 0;
            }
        }
    }

    public static void flipCol(int[][] A, int col) {
        int m = A.length;
        for (int i = 0; i < m; i++) {
            if (A[i][col] == 0) {
                A[i][col] = 1;
            } else {
                A[i][col] = 0;
            }
        }
    }
}
