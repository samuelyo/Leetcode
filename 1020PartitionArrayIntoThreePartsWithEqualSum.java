package com.leetcode.PartitionArrayIntoThreePartsWithEqualSum;

public class PartitionArrayIntoThreePartsWithEqualSum {
    public static void main(String[] args) {
        int[] A = {6, 1, 1, 13, -1, 0, -10, 20};
        boolean res = canThreePartsEqualSum(A);
        System.out.println(res);
    }

    public static boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int n : A)
            sum += n;
        if (sum % 3 != 0)
            return false;
        sum /= 3;
        int cur = 0;
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            cur += A[i];
            if (cur == sum) {
                res++;
                cur = 0;
            }
        }
        return res == 3;
    }
}
