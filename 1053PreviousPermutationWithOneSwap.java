package com.leetcode.PreviousPermutationWithOneSwap;

import java.util.Arrays;

public class PreviousPermutationWithOneSwap {
    public static void main(String[] args) {
        int[] A = {1, 9, 4, 6, 7};
        int[] res = prevPermOpt1(A);
        System.out.println(Arrays.toString(res));
    }

    public static int[] prevPermOpt1(int[] A) {
        int n = A.length, left = n - 2, right = n - 1, tmp;
        while (left >= 0 && A[left] <= A[left + 1]) left--;
        if (left < 0) return A;
        while (A[left] <= A[right]) right--;
        while (A[right - 1] == A[right]) right--;
        tmp = A[left];
        A[left] = A[right];
        A[right] = tmp;
        return A;
    }
}
