package com.leetcode.LongestTurbulentSubarray;

public class LongestTurbulentSubarray {
    public static void main(String[] args) {
        int[] A = {9, 4, 2, 10, 7, 8, 8, 1, 9};
        int res = maxTurbulenceSize(A);
        System.out.println(res);
    }

    public static int maxTurbulenceSize(int[] A) {
        int res = 0;
        for (int i = 0, cnt = 0; i + 1 < A.length; ++i, cnt *= -1) {
            if (A[i] > A[i + 1]) cnt = cnt > 0 ? cnt + 1 : 1;
            else if (A[i] < A[i + 1]) cnt = cnt < 0 ? cnt - 1 : -1;
            else cnt = 0;
            res = Math.max(res, Math.abs(cnt));
        }
        return res + 1;
    }
}
