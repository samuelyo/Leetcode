package com.leetcode.BestSightseeingPair;

public class BestSightseeingPair2 {
    public static void main(String[] args) {
        int[] A = {8, 1, 5, 2, 6};
        int res = maxScoreSightseeingPair(A);
        System.out.println(res);
    }

    public static int maxScoreSightseeingPair(int[] A) {
        int max_so_far = A[0];
        int result = 0;
        for (int i = 1; i < A.length; i++) {
            result = Math.max(result, A[i] + max_so_far - i);
            max_so_far = Math.max(max_so_far, A[i] + i);
        }
        return result;
    }
}
