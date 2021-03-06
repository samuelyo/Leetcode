package com.leetcode.DeleteColumnsToMakeSortedIII;

import java.util.Arrays;

public class DeleteColumnsToMakeSortedIII {
    public static void main(String[] args) {
        String[] A = {"babca", "bbazb"};
        int res = minDeletionSize(A);
        System.out.println(res);
    }

    public static int minDeletionSize(String[] A) {
        int m = A.length, n = A[0].length(), res = n - 1, k;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int j = 0; j < n; ++j) {
            for (int i = 0; i < j; ++i) {
                for (k = 0; k < m; ++k) {
                    if (A[k].charAt(i) > A[k].charAt(j)) break;
                }
                if (k == m && dp[i] + 1 > dp[j])
                    dp[j] = dp[i] + 1;
            }
            res = Math.min(res, n - dp[j]);
        }
        return res;
    }
}
