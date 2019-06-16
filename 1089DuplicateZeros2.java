package com.leetcode.DuplicateZeros;

import java.util.Arrays;

public class DuplicateZeros2 {
    public static void main(String[] args) {
        int[] arr = {1, 0, 2, 3, 0, 4, 5, 0};
        duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void duplicateZeros(int[] A) {
        int n = A.length, i = 0, j = 0;
        for (i = 0; i < n; ++i, ++j) {
            if (A[i] == 0) ++j;
        }
        for (i = i - 1; i >= 0; --i) {
            if (--j < n)
                A[j] = A[i];
            if (A[i] == 0 && --j < n)
                A[j] = 0;
        }
    }
}
