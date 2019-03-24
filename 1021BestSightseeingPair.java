package com.leetcode.BestSightseeingPair;

public class BestSightseeingPair {
    public static void main(String[] args) {
        int[] A = {8, 1, 5, 2, 6};
        int res = maxScoreSightseeingPair(A);
        System.out.println(res);
    }

    public static int maxScoreSightseeingPair(int[] A) {
        int ans = A[0];
        int prevBestIdx = 0;
        for (int j = 1; j < A.length; j++) {
            ans = Math.max(ans, A[prevBestIdx] + prevBestIdx + A[j] - j);
            if (A[prevBestIdx] + prevBestIdx < A[j] + j) {
                prevBestIdx = j;
            }
        }
        return ans;
    }
}
