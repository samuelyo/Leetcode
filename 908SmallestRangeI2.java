package com.leetcode.SmallestRangeI;

public class SmallestRangeI2 {
    public static void main(String[] args) {
        int[] A = {0, 10};
        int K = 2;
        int res = smallestRangeI(A, K);
        System.out.println(res);
    }

    public static int smallestRangeI(int[] A, int K) {
        int mx = A[0], mn = A[0];
        for (int a : A) {
            mx = Math.max(mx, a);
            mn = Math.min(mn, a);
        }
        return Math.max(0, mx - mn - 2 * K);
    }
}
