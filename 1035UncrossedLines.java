package com.leetcode.UncrossedLines;

public class UncrossedLines {
    public static void main(String[] args) {
        int[] A = {1, 4, 2};
        int[] B = {1, 2, 4};
        int res = maxUncrossedLines(A, B);
        System.out.println(res);
    }

    public static int maxUncrossedLines(int[] A, int[] B) {
        int m = A.length, n = B.length, dp[][] = new int[m + 1][n + 1];
        for (int i = 1; i <= m; ++i)
            for (int j = 1; j <= n; ++j)
                if (A[i - 1] == B[j - 1])
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
        return dp[m][n];
    }
}
