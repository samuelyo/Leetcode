package com.leetcode.MovingStonesUntilConsecutiveII;

import java.util.Arrays;

public class MovingStonesUntilConsecutiveII {
    public static void main(String[] args) {
        int[] A = {7, 4, 9};
        int[] res = numMovesStonesII(A);
        System.out.println(Arrays.toString(res));
    }

    public static int[] numMovesStonesII(int[] A) {
        Arrays.sort(A);
        int i = 0, n = A.length, low = n;
        int high = Math.max(A[n - 1] - n + 2 - A[1], A[n - 2] - A[0] - n + 2);
        for (int j = 0; j < n; ++j) {
            while (A[j] - A[i] >= n) ++i;
            if (j - i + 1 == n - 1 && A[j] - A[i] == n - 2)
                low = Math.min(low, 2);
            else
                low = Math.min(low, n - (j - i + 1));
        }
        return new int[]{low, high};
    }
}
