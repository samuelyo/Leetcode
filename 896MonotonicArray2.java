package com.leetcode.MonotonicArray;

public class MonotonicArray2 {
    public static void main(String[] args) {
        int[] A = {1, 1, 2};
        System.out.println(isMonotonic(A));
    }

    public static boolean isMonotonic(int[] A) {
        boolean inc = true, dec = true;
        for (int i = 1; i < A.length; ++i) {
            inc &= A[i - 1] <= A[i];
            dec &= A[i - 1] >= A[i];
        }
        return inc || dec;
    }
}
