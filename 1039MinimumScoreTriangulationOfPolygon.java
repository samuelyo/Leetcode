package com.leetcode.MinimumScoreTriangulationOfPolygon;

public class MinimumScoreTriangulationOfPolygon {
    public static void main(String[] args) {
        int[] A = {1, 2, 3};
        System.out.println(minScoreTriangulation(A));
    }

    public static int minScoreTriangulation(int[] A) {
        int n = A.length;
        int[][] dp = new int[n][n];
        for (int d = 2; d < n; ++d) {
            for (int i = 0; i + d < n; ++i) {
                int j = i + d;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; ++k)
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j] + A[i] * A[j] * A[k]);
            }
        }
        return dp[0][n - 1];
    }
}
