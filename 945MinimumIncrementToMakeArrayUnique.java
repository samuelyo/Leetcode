package com.leetcode.MinimumIncrementToMakeArrayUnique;

import java.util.Arrays;

public class MinimumIncrementToMakeArrayUnique {
    public static void main(String[] args) {
        int[] A = {3, 2, 1, 2, 1, 7};
        System.out.println(minIncrementForUnique(A));
    }

    public static int minIncrementForUnique(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        Arrays.sort(A);
        int count = 0;
        int need = 0;
        for (int i = 0; i < A.length; i++) {
            int cur = A[i];
            if (need - cur > 0) {
                count += need - cur;
                need++;
            } else {
                need = cur + 1;
            }
        }
        return count;
    }
}
