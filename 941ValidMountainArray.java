package com.leetcode.ValidMountainArray;

public class ValidMountainArray {
    public static void main(String[] args) {
        int[] A = {0, 3, 2, 1};
        boolean res = validMountainArray(A);
        System.out.println(res);
    }

    public static boolean validMountainArray(int[] A) {
        if (A == null || A.length == 0 || A.length < 3) {
            return false;
        }
        boolean flag = false;
        int index = 1;
        while (index < A.length && A[index] > A[index - 1]) {
            index++;
            flag = true;
        }
        if (index == A.length) {
            return false;
        }
        while (index < A.length && A[index] < A[index - 1]) {
            index++;
        }
        return index == A.length && flag;
    }
}
