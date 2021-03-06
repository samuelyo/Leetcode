package com.leetcode.LengthOfLongestFibonacciSubsequence;

import java.util.*;

public class LengthOfLongestFibonacciSubsequence2 {
    public static void main(String[] args) {
        int[] A = {1, 3, 7, 11, 12, 14, 18};
        System.out.println(lenLongestFibSubseq(A));

    }

    public static int lenLongestFibSubseq(int[] A) {
        int m = A.length, n = A.length;
        int[][] dp = new int[m][n];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            map.put(A[i], i);
            for (int j = i; j < n; j++) {
                dp[i][j] = 2;
            }
        }
        for (int j = 2; j < n; j++) {
            for (int i = j - 1; i > 0; i--) {
                int target = A[j] - A[i];
                if (!map.containsKey(target)) {
                    continue;
                }
                int index = map.get(target);
                dp[i][j] = Math.max(dp[i][j], dp[index][i] + 1);
            }
        }
        int result = 0;
        for (int j = 2; j < n; j++) {
            for (int i = 1; i < n - 1; i++) {
                if (dp[i][j] > 2) {
                    result = Math.max(result, dp[i][j]);
                }
            }
        }
        return result;
    }
}
