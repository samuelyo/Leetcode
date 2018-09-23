package com.leetcode.SmallestRangeII;

import java.util.Arrays;

public class SmallestRangeII {
    public static void main(String[] args) {
        int[] A = {1, 3, 6};
        int K = 3;
        int res = smallestRangeII(A, K);
        System.out.println(res);
    }

    public static int smallestRangeII(int[] A, int K) {
        Arrays.sort(A);
        int n = A.length, mx = A[n - 1], mn = A[0], res = mx - mn;
        for (int i = 0; i < n - 1; ++i) {
            mx = Math.max(mx, A[i] + 2 * K);
            mn = Math.min(A[i + 1], A[0] + 2 * K);
            res = Math.min(res, mx - mn);
        }
        return res;
    }
}
