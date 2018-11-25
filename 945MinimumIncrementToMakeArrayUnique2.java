package com.leetcode.MinimumIncrementToMakeArrayUnique;

import java.util.Arrays;

public class MinimumIncrementToMakeArrayUnique2 {
    public static void main(String[] args) {
        int[] A = {3, 2, 1, 2, 1, 7};
        System.out.println(minIncrementForUnique(A));
    }

    public static int minIncrementForUnique(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        Arrays.sort(A);
        int cur = A[0], result = 0;
        for (int a : A) {
            if (a < cur) {
                result += cur - a;
            }
            cur = Math.max(a + 1, cur + 1);
        }
        return result;
    }
}
