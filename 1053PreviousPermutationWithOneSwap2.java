package com.leetcode.PreviousPermutationWithOneSwap;

import java.util.Arrays;

public class PreviousPermutationWithOneSwap2 {
    public static void main(String[] args) {
        int[] A = {3, 2, 1};
        int[] res = prevPermOpt1(A);
        System.out.println(Arrays.toString(res));
    }

    public static int[] prevPermOpt1(int[] A) {
        if (A == null || A.length == 0) {
            return A;
        }
        int i = A.length - 1;
        while (i > 0 && A[i] >= A[i - 1]) {
            i--;
        }
        if (i == 0) {
            return A;
        }
        int value = A[i - 1];
        int j = A.length - 1;
        while (j >= 0 && A[j] >= value) {
            j--;
        }
        while (j > 0 && A[j] == A[j - 1]) {
            j--;
        }
        int temp = A[j];
        A[j] = A[i - 1];
        A[i - 1] = temp;
        return A;
    }
}
