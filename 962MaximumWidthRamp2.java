package com.leetcode.MaximumWidthRamp;

import java.util.Stack;

public class MaximumWidthRamp2 {
    public static void main(String[] args) {
        int[] A = {9, 8, 1, 0, 1, 9, 4, 0, 4, 1};
        int res = maxWidthRamp(A);
        System.out.println(res);
    }

    public static int maxWidthRamp(int[] A) {
        int n = A.length;
        int i, j, max = 0;
        int[] maxR = new int[n], minL = new int[n];
        minL[0] = A[0];
        for (i = 1; i < n; i++) {
            minL[i] = Math.min(A[i], minL[i - 1]);
        }
        maxR[n - 1] = A[n - 1];
        for (j = n - 2; j >= 0; j--) {
            maxR[j] = Math.max(A[j], maxR[j + 1]);
        }
        i = 0;
        j = 0;
        while (i < n && j < n) {
            if (minL[i] <= maxR[j]) {
                max = Math.max(max, j - i);
                j++;
            } else {
                i++;
            }
        }
        return max;
    }
}
