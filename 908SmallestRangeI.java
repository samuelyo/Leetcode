package com.leetcode.SmallestRangeI;

public class SmallestRangeI {
    public static void main(String[] args) {
        int[] A = {0, 10};
        int K = 2;
        int res = smallestRangeI(A, K);
        System.out.println(res);
    }

    public static int smallestRangeI(int[] A, int K) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : A) {
            min = Math.min(num, min);
            max = Math.max(num, max);
        }
        min += K;
        max -= K;
        if (max - min <= 0) {
            return 0;
        } else {
            return max - min;
        }
    }
}
