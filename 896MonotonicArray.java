package com.leetcode.MonotonicArray;

public class MonotonicArray {
    public static void main(String[] args) {
        int[] A = {1, 1, 2};
        System.out.println(isMonotonic(A));
    }

    public static boolean isMonotonic(int[] A) {
        if (A == null || A.length == 0) {
            return false;
        }
        if (A.length == 1) {
            return true;
        }
        int index = 1;
        while (index < A.length && A[index] == A[index - 1]) {
            index++;
        }
        if (index == A.length) {
            return true;
        }
        int num1 = A[index - 1];
        int num2 = A[index];
        boolean flag = true;
        if (num2 <= num1) {
            flag = false;
        }
        for (int i = 2; i < A.length; i++) {
            int pre = A[i - 1];
            int cur = A[i];
            if (flag) {
                if (cur < pre) {
                    return false;
                }
            } else {
                if (cur > pre) {
                    return false;
                }
            }
        }
        return true;
    }
}
