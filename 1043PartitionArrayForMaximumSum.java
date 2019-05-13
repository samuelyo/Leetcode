package com.leetcode.PartitionArrayForMaximumSum;

public class PartitionArrayForMaximumSum {
    public static void main(String[] args) {
        int[] A = {1, 15, 7, 9, 2, 5, 10};
        int K = 3;
        System.out.println(maxSumAfterPartitioning(A, K));
    }

    public static int maxSumAfterPartitioning(int[] A, int K) {
        int N = A.length, dp[] = new int[N];
        for (int i = 0; i < N; ++i) {
            int curMax = 0;
            for (int k = 1; k <= K && i - k + 1 >= 0; ++k) {
                curMax = Math.max(curMax, A[i - k + 1]);
                dp[i] = Math.max(dp[i], (i >= k ? dp[i - k] : 0) + curMax * k);
            }
        }
        return dp[N - 1];
    }
}
