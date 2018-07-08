package com.leetcode.TransposeMatrix;

public class TransposeMatrix2 {
    public static void main(String[] args) {
        int[][] A = {{1, 2, 3}, {4, 5, 6}};
        int[][] res = transpose(A);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] transpose(int[][] A) {
        int m = A.length, n = m == 0 ? 0 : A[0].length;
        int[][] res = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res[i][j] = A[j][i];
            }
        }
        return res;
    }
}
