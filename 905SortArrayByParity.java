package com.leetcode.SortArrayByParity;

public class SortArrayByParity {
    public static void main(String[] args) {
        int[] A = {3, 1, 2, 4};
        int[] res = sortArrayByParity(A);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }

    public static int[] sortArrayByParity(int[] A) {
        if (A == null || A.length == 0) {
            return new int[0];
        }
        int[] res = new int[A.length];
        int even = 0;
        int odd = A.length - 1;
        for (int i = 0; i < A.length; i++) {
            int num = A[i];
            if (num % 2 == 1) {
                res[odd] = num;
                odd--;
            } else {
                res[even] = num;
                even++;
            }
        }
        return res;
    }
}
