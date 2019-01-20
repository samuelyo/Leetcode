package com.leetcode.LongestTurbulentSubarray;

public class LongestTurbulentSubarray2 {
    public static void main(String[] args) {
        int[] A = {9, 4, 2, 10, 7, 8, 8, 1, 9};
        int res = maxTurbulenceSize(A);
        System.out.println(res);
    }

    public static int maxTurbulenceSize(int[] A) {
        if (A.length <= 2)
            return A.length;
        int max = 1, current = 2;
        for (int i = 1; i < A.length - 1; i++) {
            if ((A[i - 1] < A[i] && A[i] > A[i + 1]) || (A[i - 1] > A[i] && A[i] < A[i + 1]))
                current += 1;
            else
                current = 2;
            max = Math.max(max, current);
        }
        return max;
    }
}
