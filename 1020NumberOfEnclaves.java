package com.leetcode.NumberOfEnclaves;

public class NumberOfEnclaves {
    public static void main(String[] args) {
        int[][] A = {{0, 0, 0, 0}, {1, 0, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}};
        int res = numEnclaves(A);
        System.out.println(res);
    }

    public static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static int numEnclaves(int[][] A) {
        if (A == null || A.length == 0 || A[0].length == 0) {
            return 0;
        }
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (i == 0 || i == A.length - 1 || j == 0 || j == A[0].length - 1) {
                    if (A[i][j] == 1) {
                        dfs(A, i, j);
                    }
                }
            }
        }
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void dfs(int[][] A, int i, int j) {
        if (i < 0 || i >= A.length || j < 0 || j >= A[0].length || A[i][j] == 0) {
            return;
        }
        A[i][j] = 0;
        for (int m = 0; m < dir.length; m++) {
            dfs(A, i + dir[m][0], j + dir[m][1]);
        }
    }
}
