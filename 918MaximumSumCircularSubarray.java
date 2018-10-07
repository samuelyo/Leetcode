package com.leetcode.MaximumSumCircularSubarray;

public class MaximumSumCircularSubarray {
    public static void main(String[] args) {
        int[] A = {-2, -3, -1};
        System.out.println(maxSubarraySumCircular(A));
    }

    public static int maxSubarraySumCircular(int[] A) {
        int total = 0, maxSum = -30000, curMax = 0, minSum = 30000, curMin = 0;
        for (int a : A) {
            curMax = Math.max(curMax + a, a);
            maxSum = Math.max(maxSum, curMax);
            curMin = Math.min(curMin + a, a);
            minSum = Math.min(minSum, curMin);
            total += a;
        }
        return maxSum > 0 ? Math.max(maxSum, total - minSum) : maxSum;
    }
}
