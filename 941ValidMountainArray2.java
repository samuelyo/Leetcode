package com.leetcode.ValidMountainArray;

public class ValidMountainArray2 {
    public static void main(String[] args) {
        int[] A = {0, 3, 2, 1};
        boolean res = validMountainArray(A);
        System.out.println(res);
    }

    public static boolean validMountainArray(int[] A) {
        int n = A.length, i = 0, j = n - 1;
        while (i + 1 < n && A[i] < A[i + 1]) i++;
        while (j > 0 && A[j - 1] > A[j]) j--;
        return i > 0 && i == j && j < n - 1;
    }
}
