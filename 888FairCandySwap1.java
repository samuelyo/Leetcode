package com.leetcode.FairCandySwap;

public class FairCandySwap1 {
    public static void main(String[] args) {
        int[] A = {1, 1};
        int[] B = {2, 2};
        int[] res = fairCandySwap(A, B);
        System.out.println(res[0] + " " + res[1]);
    }

    public static int[] fairCandySwap(int[] A, int[] B) {
        if (A == null || B == null || A.length == 0 || B.length == 0) {
            return new int[0];
        }
        int sum1 = 0;
        for (int num : A) {
            sum1 += num;
        }
        int sum2 = 0;
        for (int num : B) {
            sum2 += num;
        }
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (sum1 - A[i] + B[j] == sum2 - B[j] + A[i]) {
                    return new int[]{A[i], B[j]};
                }
            }
        }
        return new int[0];
    }
}
